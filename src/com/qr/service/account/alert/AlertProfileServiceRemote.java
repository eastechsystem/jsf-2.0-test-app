package com.qr.service.account.alert;

import java.util.ArrayList;

import javax.ejb.Remote;

import com.qr.model.account.alert.AlertProfile;

@Remote
public interface AlertProfileServiceRemote {
	void saveAlertProfile(AlertProfile alertProfile);
	boolean deleteAlertProfile(int id);
	boolean updateAlertProfile(AlertProfile alertProfile);
	ArrayList<AlertProfile> getAllAlertProfiles();
}
