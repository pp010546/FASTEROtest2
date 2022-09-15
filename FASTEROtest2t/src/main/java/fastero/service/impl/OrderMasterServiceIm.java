package com.fastero.service.impl;

import com.fastero.common.Result;
import com.fastero.dao.impl.OderMasterDAOIm;
import com.fastero.service.intf.OrderMasterServiceIn;

public class OrderMasterServiceIm implements OrderMasterServiceIn {

	OderMasterDAOIm DAO;
	Result R;
	
	public OrderMasterServiceIm() {
		DAO = new OderMasterDAOIm();
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
