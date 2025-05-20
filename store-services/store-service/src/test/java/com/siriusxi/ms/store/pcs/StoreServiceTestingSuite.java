package com.siriusxi.ms.store.pcs;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Store Service Testing Suite")
@SelectClasses({StoreServiceApplicationTests.class, MessagingTests.class})
class StoreServiceTestingSuite {}
