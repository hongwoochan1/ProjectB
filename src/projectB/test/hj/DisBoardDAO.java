package projectB.test.hj;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projectB.model.petition.DiscussionDTO;

@Service("disBoardDAO")
public class DisBoardDAO implements DisBoardService{
	
	@Autowired
	private SqlSessionTemplate bDao = null;
	
	@Override
	public void insertArticle(DiscussionDTO article) throws Exception {
	}

	@Override
	public int getArticleCount() throws Exception {
		int a = bDao.selectOne("disBoard.getArticleCount");
		return a;
	}
	
	@Override
	public int getArticleCount(String keyword) throws Exception {
		int a = bDao.selectOne("disBoard.getArticleCount", keyword);
		return a;
	}

	@Override
	public List<DiscussionDTO> getArticles(int start, int end) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start",start);
		map.put("end",end);
		List<DiscussionDTO> articleList = bDao.selectList("disBoard.getArticles", map);
		return articleList;
	}

	@Override
	public List<DiscussionDTO> getArticles(int start, int end, String keyword) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start",start);
		map.put("end",end);
		map.put("keyword",keyword);
		List<DiscussionDTO> articleList = bDao.selectList("disBoard.getArticles", map);
		return articleList;
	}

	@Override
	public List<DiscussionDTO> getArticles(int start, int end, int sort) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start",start);
		map.put("end",end);
		map.put("sort",sort);
		List<DiscussionDTO> articleList = bDao.selectList("disBoard.getArticles", map);
		return articleList;
	}


	@Override
	public DiscussionDTO getArticle(int num) throws Exception {
		return bDao.selectOne("disBoard.getArticle", num);
	}

	@Override
	public int updateArticle(DiscussionDTO article) throws Exception {
		return 0;
	}

	@Override
	public int deleteArticle(int num) throws Exception {
		return 0;
	}

	@Override
	public void report(int num) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void openStateOpen(int num) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void openStateCheck(int num) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void openStateClose(int num) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<DiscussionDTO> getBestArticles(int start, int end, int sort) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start",start);
		map.put("end",end);
		map.put("sort",sort);
		List<DiscussionDTO> articleList = bDao.selectList("disBoard.getBestArticles", map);
		return articleList;
	}

	@Override
	public List<DiscussionDTO> getBestCArticles(int start, int end, int sort) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start",start);
		map.put("end",end);
		map.put("sort",sort);
		List<DiscussionDTO> articleCList = bDao.selectList("disBoard.getBestCArticles", map);
		return articleCList;
	}
	
	@Override
	public void insertVote(Map<String, Object> voteMap) {
		Map<String, Object> map = new HashMap<>(voteMap);
		//map.put("discussionNum",discussionNum);
		//map.put("writer",writer);
		
		bDao.insert("disBoardVote.insertVote", map);
	}
	
	@Override
	public int CheckVote(int discussionNum, String writer) {
		if(writer == null || discussionNum <= 0)
			return -1;
		Map<String, Object> map = new HashMap<>();
		map.put("discussionNum",discussionNum);
		map.put("writer",writer);
		
		return bDao.selectOne("disBoardVote.votecheck", map);
	}

	@Override
	public void updateVoteByUp(int discussionNum) {
		bDao.update("disBoard.agreement", discussionNum);
	}
	
	@Override
	public void updateVoteByDown(int discussionNum) {
		bDao.update("disBoard.opposition", discussionNum);
	}
}
