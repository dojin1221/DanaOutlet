package com.bit.daNaOutlet.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.bit.daNaOutlet.model.entity.ClipVo;
import com.bit.daNaOutlet.model.entity.DpgVo;
import com.bit.daNaOutlet.model.entity.HotDealVo;
import com.bit.daNaOutlet.model.entity.LoginVo;
import com.bit.daNaOutlet.model.entity.MemberVo;
import com.bit.daNaOutlet.model.entity.ReplyVo;

public class MemberDaoImpl implements MemberDao {
	SqlSession session;

	Logger log;

	public void setSession(SqlSession session) {
		this.session = session;
	}

	public MemberDaoImpl() {
		// TODO Auto-generated constructor stub
		try {
			log = Logger.getLogger(Class.forName("com.bit.daNaOutlet.model.MemberDaoImpl"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 회원관리
	@Override
	public List<MemberVo> selectAll() throws Exception {
		// TODO Auto-generated method stub
		return session.selectList("com.bit.daNaOutlet.model.MemberDao.selectAll");
	}

	@Override
	public MemberVo selectOne(int mnum) throws Exception {
		return session.selectOne("com.bit.daNaOutlet.model.MemberDao.selectOne", mnum);
	}

	@Override
	public int mNumOne() throws Exception { // 회원 번호 프라이머리키 시퀀스 기능 대신 해주는 Dao
		return session.selectOne("com.bit.daNaOutlet.model.MemberDao.mnumOne");
	}

	@Override
	public void memberAdd(MemberVo bean) {
		session.insert("com.bit.daNaOutlet.model.MemberDao.memberAdd", bean);
	}

	@Override
	public int idDoubleChk(String chkId) throws Exception {
		return session.selectOne("com.bit.daNaOutlet.model.MemberDao.idDoubleChk", chkId);		
	}
	
	
	// HOTDEAL table 의 primary key max 값 조회 ,회원 번호 프라이머리키 시퀀스 기능 대신 해주는 Dao
	@Override
	public int hotDealNumOne() throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne("com.bit.daNaOutlet.model.MemberDao.hotDealNumOne");
	}

	// HOTDEAL DB insert 및 이미지 업로드
	@Override
	public void hotDealAdd(HotDealVo bean) {
		session.insert("com.bit.daNaOutlet.model.MemberDao.hotDealAdd", bean);
	}

	// HOTDEAL 에 저장된 값 갯수 count
	@Override
	public int hotDealCount() throws Exception {
		return session.selectOne("com.bit.daNaOutlet.model.MemberDao.hotDealCount");
	}

	// 핫딜 리스트 정보
	@Override
	public List<HotDealVo> hotDealAll() throws Exception {
		return session.selectList("com.bit.daNaOutlet.model.MemberDao.hotDealAll");
	}

	// 클립
	@Override
	public List<ClipVo> clipList() throws Exception {
		// TODO Auto-generated method stub
		return session.selectList("com.bit.daNaOutlet.model.MemberDao.clipList");
	}

	@Override // 로그인 아이디 비번 확인- 1 - 확인 2 - 실패
	public int login(LoginVo bean) throws Exception {
		// 단위테스트 완료
		return (Integer) session.selectOne("com.bit.daNaOutlet.model.MemberDao.loginChk", bean);

	}

	@Override // 카카오톡 로그인
	public int loginKakao(LoginVo bean) {

		return session.insert("com.bit.daNaOutlet.model.MemberDao.loginKakao", bean);
	}

	@Override
	public int kakolognum() throws Exception { // 회원 번호 프라이머리키 시퀀스 기능 대신 해주는 Dao
		return session.selectOne("com.bit.daNaOutlet.model.MemberDao.idKakoaLogCount");
	}

	/* Dpg 관련 부분 */
	@Override // Dpg 디테일
	public DpgVo dpgOne(int dpgNum) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne("com.bit.daNaOutlet.model.MemberDao.dpgOne", dpgNum);
	}

	@Override // Dpg 시퀀스
	public int dpgNumOne() throws Exception {

		return session.selectOne("com.bit.daNaOutlet.model.MemberDao.dpgNumOne");
	}

	@Override
	public void dpgAdd(DpgVo bean) throws Exception {
		session.insert("com.bit.daNaOutlet.model.MemberDao.dpgAdd", bean);
	}
	/* ......................................................... */

	@Override
	public List<DpgVo> dpgBestList() throws Exception {
		return session.selectList("com.bit.daNaOutlet.model.MemberDao.dpgBestList");
	}

	@Override
	public List<DpgVo> dpgImgLinkList() throws Exception {
		return session.selectList("com.bit.daNaOutlet.model.MemberDao.dpgImgLinkList");
	}

	@Override
	public List<DpgVo> dpgNoneLinkList() throws Exception {
		return session.selectList("com.bit.daNaOutlet.model.MemberDao.dpgNoneLinkList");

	}

	@Override
	public List<DpgVo> dpgAdminList() throws Exception {
		return session.selectList("com.bit.daNaOutlet.model.MemberDao.dpgAdminList");
	}

	// 댓글 Dao
	@Override
	public List<ReplyVo> replyCall(int fatherContentsNum) throws Exception {

		return session.selectList("com.bit.daNaOutlet.model.MemberDao.replyCall", fatherContentsNum);
	}

	@Override
	public int replyNumOne() throws Exception {
		return session.selectOne("com.bit.daNaOutlet.model.MemberDao.replyNumOne");
	
	}

	@Override
	public void replyAdd(ReplyVo bean) throws Exception {
		session.insert("com.bit.daNaOutlet.model.MemberDao.replyAdd", bean);		
	}

	

}