package project.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;
import project.dto.DiaryDto;
import project.dto.GoalDto;
import project.dto.MoodDto;
import project.dto.ShareMemberDto;
import project.dto.ShareRoomDto;
import project.dto.WeatherDto;
import project.mapper.DiaryMapper;

@Slf4j
@Service
public class DiaryServiceImpl implements DiaryService {

	@Autowired
	private DiaryMapper diaryMapper;
	
	// 1. 개인 일기 목록 조회
	@Override
	public List<DiaryDto> selectPrivateList(String memberId) throws Exception{
		return diaryMapper.selectPrivateList(memberId);
	}
	
	// 1-1. 날짜별 개인 일기 목록 조회
	@Override
	public List<DiaryDto> selectPrivateListByDt(String memberId, String createdDt) throws Exception {
		return diaryMapper.selectPrivateListByDt(memberId, createdDt);
	}

	
	@Override
	public List<GoalDto> selectGoalList(String memberId) throws Exception {
		return diaryMapper.selectGoalList(memberId);
	}
	
	@Override
	public int insertGoal(GoalDto goalDto) throws Exception {
		return diaryMapper.insertGoal(goalDto);
	}
	
	@Override
	public int updateGoal(String memberId) throws Exception {
		return diaryMapper.updateGoal(memberId);
	}
	
	// 2, 9. 개인/교환 일기 작성 화면 - 기분, 날씨 선택
	public List<WeatherDto> weatherList() throws Exception {
		return diaryMapper.weatherList();
	}
	 
	public List<MoodDto> moodList() throws Exception{
		return diaryMapper.moodList();
	}
	
	// 3. 개인 일기 작성
	@Override
	public int insertPrivate(DiaryDto diaryDto) throws Exception{
		return diaryMapper.insertPrivate(diaryDto);
	}
	
	// 4. 개인 일기 상세 조회
	@Override
	public DiaryDto selectPrivateDetail(int diaryId) throws Exception {
		return diaryMapper.selectPrivateDetail(diaryId);
	}
	
	// 5. 개인 일기 수정
	@Override
	public int updatePrivate(DiaryDto diaryDto) throws Exception{
		return diaryMapper.updatePrivate(diaryDto);
	}
	
	// 6. 개인 일기 삭제
	@Override
	public int deletePrivate(int diaryId) throws Exception{
		return diaryMapper.deletePrivate(diaryId);
	}
	
	// 7. 교환 일기 그룹 목록 조회
	@Override
	public List<ShareRoomDto> selectPublicList() throws Exception{
		return diaryMapper.selectPublicList();
	}
	
	// 8. 교환 일기 목록 조회
	@Override
	public List<Map<String, Object>> selectPublicShareList(int shareRoomId) throws Exception{
		return diaryMapper.selectPublicShareList(shareRoomId);
	}
	
	// 8-1. 날짜별 교환 일기 목록 조회
	@Override
	public List<Map<Object, Object>> selectPublicShareListByDt(int shareRoomId, String createdDt) throws Exception {
		return diaryMapper.selectPublicShareListByDt(shareRoomId, createdDt); 
	}
	
	// 10. 교환 일기 작성
	@Override
	public int insertPublic(DiaryDto diaryDto) throws Exception {
		return diaryMapper.insertPublic(diaryDto);
	}
	
	// 11. 교환 일기 상세 조회
	@Override
	public List<DiaryDto> selectPublicDetail(int shareRoomId, String createdDt) throws Exception {
		return diaryMapper.selectPublicDetail(shareRoomId, createdDt);
	}
	
//	@Override
//	public int updatePublic(DiaryDto diaryDto) throws Exception{
//		return diaryMapper.updatePublic(diaryDto);
//	}
	
//	@Override
//	public int deletePublic(int shareRoomId, int diaryId) throws Exception{
//		return diaryMapper.deletePublic(shareRoomId, diaryId);
//	}
	
//	@Override
//	public int deletePublic(DiaryDto diaryDto) throws Exception{
//		return diaryMapper.deletePublic(diaryDto);
//	}
	
	@Override
	public List<GoalDto> selectGoalList() throws Exception {
		return diaryMapper.selectGoalList();
	}

	// 12. 교환 일기 그룹 추가
	@Override
	public int addGroup(ShareRoomDto shareRoomDto) throws Exception {
		return diaryMapper.addGroup(shareRoomDto);
	}

	// 13. 교환 일기 멤버 추가
	@Override
	public int addGroupNext(ShareMemberDto shareMemberDto) throws Exception {
		return diaryMapper.addGroupNext(shareMemberDto);
	}
	
}
