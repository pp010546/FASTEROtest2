package com.fastero.service.impl;

import com.fastero.common.Result;
import com.fastero.dao.impl.OderMasterDAOIm;
import com.fastero.dao.impl.UserStoreConnDAOIm;
import com.fastero.service.intf.OrderMasterServiceIn;
import com.fastero.service.intf.UserStoreConnServiceIn;

public class UserStoreConnServiceIm implements UserStoreConnServiceIn {

	UserStoreConnDAOIm DAO;
	Result R;
	
	public UserStoreConnServiceIm() {
		DAO = new UserStoreConnDAOIm();
		R = new Result();
	}
	
	@Override
	public Result getAll() {
		try {
			return R.success(DAO.getAll());
		} catch (Exception e) {
			return R.fail(e.toString());
		}
	}

}
