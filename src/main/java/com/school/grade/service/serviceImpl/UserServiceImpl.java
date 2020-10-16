package com.school.grade.service.serviceImpl;

import com.school.grade.entity.LoginParam;
import com.school.grade.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author weston
 * @version 版本1.0
 */
@Service
public class UserServiceImpl implements UserService {
//	@Autowired
//	private GradeTeachersMapper kitchenAccountsMapper;
//	@Autowired
//	private KitchenPermissionMapper kitchenPermissionMapper;
//	@Autowired
//	private KitchenRolePemissionMapper kitchenRolePemissionMapper;
//	@Autowired
//	private GradeStudentsMapper clerkMapper;

//	@Override
//	public Map<String, Object> SeleUserById(HttpServletRequest req, HttpServletResponse res) {
//		Map<String, Object> retobj = new HashMap<String, Object>();
//		logger.info("SeleUserById=====>Begin");
//		/**
//		 * 帐号ID
//		 */
//		Integer accountId = null;
//		if (SqlLikeUitl.isBank(req, "accountId") != null) {
//			accountId = Integer.parseInt(SqlLikeUitl.isBank(req, "accountId"));
//		}
//		if (accountId != null) {
//			GradeStudents pcwAcc = kitchenAccountsMapper.selectById(accountId);
//			if (pcwAcc != null && pcwAcc.getClerkId() != null) {
//				GradeTeachers pcwClerk = clerkMapper.selectByPrimaryKey(pcwAcc.getClerkId());
//				pcwClerk.setClerkPhoto(Tomcat.getOrgUrl(req) + pcwClerk.getClerkPhoto());
//				retobj.put("pcwAcc", pcwAcc);
//				retobj.put("pcwClerk", pcwClerk);
//				retobj.put("code", "1");
//				retobj.put("msg", "OK");
//			} else {
//				retobj.put("code", "1");
//				retobj.put("msg", "AccountId is miss!");
//			}
//		} else {
//			retobj.put("code", "1");
//			retobj.put("msg", "AccountId is miss!");
//		}
//		logger.info("SeleUserById=====>Finish");
//		return retobj;
//	}
//
//	@Override
//	public String SeleUser(HttpServletRequest req, HttpServletResponse res, Model model) {
//		Integer accountId = null;
//		if (SqlLikeUitl.isBank(req, "accountId") != null) {
//			accountId = Integer.parseInt(SqlLikeUitl.isBank(req, "accountId"));
//		}
//		if (accountId != null) {
//
//			GradeStudents pcwAcc = kitchenAccountsMapper.selectById(accountId);
//
//			if (pcwAcc != null && pcwAcc.getClerkId() != null) {
//				GradeTeachers pcwClerk = clerkMapper.selectByPrimaryKey(pcwAcc.getClerkId());
//				pcwClerk.setClerkPhoto(Tomcat.getOrgUrl(req) + pcwClerk.getClerkPhoto());
//				model.addAttribute("pcwAcc", pcwAcc);
//				model.addAttribute("pcwClerk", pcwClerk);
//			}
//		}
//		logger.info("SeleUserById=====>Finish");
//		return "user-update";
//	}


	@Override
	public String userLogin(LoginParam info) {
		return null;
	}
}
