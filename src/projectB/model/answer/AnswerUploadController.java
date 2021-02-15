package projectB.model.answer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import projectB.model.petition.CategoryDTO;
import projectB.model.petition.PetitionDTO;
import projectB.model.petition.PetitionIndicatorDTO;
import projectB.model.petitioner.PetitionerDTO;
import projectB.model.answerContentService.AnswerContentService;
import projectB.model.answerListService.AnswerListService;
import projectB.model.answerUploadService.*;
import projectB.model.login.LoginUtils;


@Controller 
@RequestMapping("answer")
public class AnswerUploadController {

    @Autowired 
    private AnswerUploadService AnswerUploadService = null;
    
    @Autowired 
    private AnswerContentService AnswerContentService = null;
  
    @RequestMapping("answerUpload.aa")
    public String answerUpload(@RequestParam("petitionNum") int petitionNum, Model model,HttpSession session) throws Exception {
    
    
    String id = LoginUtils.getLoginID(session);
    PetitionerDTO petitionerDTO = AnswerUploadService.getPetitionerInfo(id);
    model.addAttribute("petitionerDTO",petitionerDTO);
    
      
    PetitionDTO petitionDTO = AnswerUploadService.getPetitionInfo(petitionNum);
    model.addAttribute("petitionNum", petitionNum);
    model.addAttribute("petitionDTO",petitionDTO);
    
    List<AnswerDTO> answerList = new ArrayList<>();
    answerList = AnswerContentService.getAnswerByPetitionNum(petitionNum);
    model.addAttribute("answerList",answerList);
    
    
    return "answer/answerUpload";
    }
  
    
    @RequestMapping("answerUploadPro.aa")
    public String answerUploadPro(AnswerDTO answerDTO, Model model) throws Exception {
    
    int petitionNum = answerDTO.getPetitionNum();
    int state = answerDTO.getState();
    if(state == 4) {
      AnswerUploadService.updateAnswerState(petitionNum);
      AnswerUploadService.updatePetitionState(petitionNum);
      AnswerUploadService.insertArticle(answerDTO);
    }
    
    if(state != 4) {
      AnswerUploadService.updateAnswerState(petitionNum);
      AnswerUploadService.updatePetitionState(petitionNum);
      AnswerUploadService.createRow(answerDTO);
    }
    
    
    model.addAttribute("petitionNum", petitionNum);
    
    return "answer/answerUploadPro";
    }
  
   
}
