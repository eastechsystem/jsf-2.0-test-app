package com.qr.test.suit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.qr.dao.account.test.AccountDaoTest;
import com.qr.dao.contact.test.ContactDaoTest;
@RunWith(Suite.class)
@Suite.SuiteClasses({
   AccountDaoTest.class,
   ContactDaoTest.class
})
public class JunitTestSuite {   
}  	