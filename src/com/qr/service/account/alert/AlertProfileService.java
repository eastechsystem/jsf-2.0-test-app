package com.qr.service.account.alert;

import java.util.ArrayList;

import javax.ejb.Stateless;

import com.qr.dao.account.alert.Imp.AccountAlertDaoImp;
import com.qr.model.account.alert.AlertProfile;
import com.qr.service.account.alert.AlertProfileService;

@Stateless
public class AlertProfileService implements AlertProfileServiceRemote {
	
	private AccountAlertDaoImp accountAlertDaoImp;
	private int id;
	
	
	@Override
	public void saveAlertProfile(AlertProfile alertProfile) {
		accountAlertDaoImp.saveAlertProfile(alertProfile);
	}

	@Override
	public boolean deleteAlertProfile(int id) {
		this.setId(id);
		return accountAlertDaoImp.deleteAlertProfile(this.getId());
	}

	@Override
	public boolean updateAlertProfile(AlertProfile alertProfile) {
		this.setId(alertProfile.getId());
		return accountAlertDaoImp.updateAlertProfile(alertProfile);
	}

	@Override
	public ArrayList<AlertProfile> getAllAlertProfiles() {
		return accountAlertDaoImp.getAlertProfiles();
	}

	private void setId(int id) {
		this.id=id;
	}

	
	public int getId() {
		return id;
	}
	
}
