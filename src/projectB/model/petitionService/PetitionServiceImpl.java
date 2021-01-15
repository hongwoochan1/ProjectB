package projectB.model.petitionService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projectB.model.petition.PetCommentDTO;
import projectB.model.petition.PetitionDTO;

@Service("petitionDAO")
public class PetitionServiceImpl implements PetitionService{

	@Autowired
	private SqlSessionTemplate dao = null;
	
	@Override
	public void insertArticle(PetitionDTO petition) throws Exception {
		dao.insert("petition.insertArticle", petition);
	}

	@Override
	public List<PetitionDTO> getCategory() throws Exception {
		Map map = new HashMap();
		
		
		return dao.selectList("petition.getCategory");
	}
	
	@Override
	public int getArticleCount() throws Exception {
	
		return dao.selectOne("petition.getArticleCount");
	}

	@Override
	public List<PetitionDTO> getArticles(int startRow, int endRow) throws Exception {
 
		Map map = new HashMap();
		map.put("startRow",startRow);
		map.put("endRow",endRow);
		
		List<PetitionDTO> articleList = dao.selectList("petition.getArticleAll", map);
		
		return articleList;
	}


	@Override
	public PetitionDTO updateGetArticle(int num) throws Exception {
	
		return null;
	}

	@Override
	public int getArticleCountbyState() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public List<PetitionDTO> getArtilclebyState(int state, int startRow, int endRow) throws Exception {
		Map map = new HashMap();
		map.put("state",state);
		map.put("startRow",startRow);
		map.put("endRow",endRow);
		List<PetitionDTO> stateList = dao.selectList("petition.getArticleState", map);
		return stateList;
	}

	@Override
	public PetitionDTO getArticle(int num) throws Exception {
		return dao.selectOne("petition.getArticle",num);
	}

	@Override
	public void insertPetCmt(PetCommentDTO dto) throws Exception {
		dao.insert("petition.insertPetCmt",dto);
	}

	@Override
	public List<PetitionDTO> petCmtListAll(int petitionNum) throws Exception {
		return dao.selectList("petition.petCmtListAll",petitionNum);
	}
	
	@Override
	public int petCmtCount(int petitionNum) throws Exception {
		return dao.selectOne("petition.petCmtCount",petitionNum);
	}

	@Override
	public List<PetitionDTO> petCmtList(int petitionNum, int start, int end) throws Exception {
		Map map = new HashMap();
		map.put("petitionNum",petitionNum);
		map.put("start",start);
		map.put("end",end);
		List<PetitionDTO> petCmtList = dao.selectList("petition.petCmtList",map);
		return petCmtList;
	}

	


}
