package com.projectname.e2e.tests.data.provider.phptravels;

import com.projectname.api.client.utils.RandomStringGenerator;
import com.projectname.e2e.tests.data.enums.Country;
import com.projectname.e2e.tests.data.model.RegisterUserRequest;

public class PhpTravelsProvider {

    public static RegisterUserRequest prepareRegisterUserRequest(){
        RegisterUserRequest userRequest = new RegisterUserRequest();

        userRequest.setFirstName(RandomStringGenerator.createRandomStringAlphabeticWithLen(8));
        userRequest.setLastName(RandomStringGenerator.createRandomStringAlphabeticWithLen(8));
        userRequest.setEmail(RandomStringGenerator.createRandomEmailWithPrefixLen(8));
        userRequest.setPhoneNumber(RandomStringGenerator.createRandomStringNumericWithLen(12));
        userRequest.setCompanyName(RandomStringGenerator.createRandomStringAlphabeticWithLen(10));
        userRequest.setAddress1(RandomStringGenerator.createRandomStringAlphabeticWithLen(8));
        userRequest.setAddress2(RandomStringGenerator.createRandomStringAlphabeticWithLen(8));
        userRequest.setCity(RandomStringGenerator.createRandomStringAlphabeticWithLen(8));
        userRequest.setState(RandomStringGenerator.createRandomStringAlphabeticWithLen(8));
        userRequest.setPostalCode(RandomStringGenerator.createRandomStringNumericWithLen(6));
        userRequest.setCountry(Country.getRandomCountry());
        userRequest.setPassword(RandomStringGenerator.createRandomStringAlphabeticWithLen(8));
        userRequest.setMobile(RandomStringGenerator.createRandomStringNumericWithLen(12));

//        userRequest.setFirstName("Mrdjan");
//        userRequest.setLastName("Mrksic");
//        userRequest.setEmail("mrdjanovmail@mail.com");
//        userRequest.setPhoneNumber("123456789");
//        userRequest.setCompanyName("Sumeca tableta");
//        userRequest.setAddress1("Carnojeviceva 54");
//        userRequest.setAddress2("Zmaj Jovina 42");
//        userRequest.setCity("Becej");
//        userRequest.setState("Vojvodina");
//        userRequest.setPostalCode("21220");
//        userRequest.setCountry(Country.getRandomCountry());
//        userRequest.setPassword("Admin123");
//        userRequest.setMobile("987654321");

        return userRequest;
    }
}
