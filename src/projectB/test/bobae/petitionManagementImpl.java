package projectB.test.bobae;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projectB.model.petition.CategoryDTO;
import projectB.model.petition.PetitionDTO;
import projectB.model.petition.petitionStateDTO;

@Service("petitionManegementService")
public class petitionManagementImpl implements petitionManegementService{

	@Autowired
	private SqlSessionTemplate dao = null;
	
	@Override
	public int getArticleCount() throws Exception {
		
		return dao.selectOne("adminPetition.getArticleCount");
	}

	@Override
	public List<PetitionDTO> getArticles(int startRow, int endRow) throws Exception {
		
		Map map = new HashMap();
		map.put("startRow", startRow);
		map.put("endRow", endRow);

		List<PetitionDTO> articleList = dao.selectList("adminPetition.getArticleAll", map);

		return articleList;
	}

	@Override
	public int getArticleCountbyCategory(int category) throws Exception {
		
		return dao.selectOne("adminPetition.getArticleCountCategory", category);
	}

	@Override
	public List<CategoryDTO> getCategoryList() throws Exception {
		
		 return dao.selectList("adminPetition.getCategoryList");
	}

	@Override
	public int getArticleCountbyState(int state) throws Exception {
		
		return dao.selectOne("adminPetition.getArticleCountState", state);
	}

	@Override
	public List<petitionStateDTO> getStateList() throws Exception {

		return dao.selectList("adminPetition.getStateList");
	}

}
