package com.donatedrop.profile;

import com.donatedrop.articles.PhoneNumber;
import com.donatedrop.profile.ProfileBasic;
import com.donatedrop.util.StringUtil;
import com.donatedrop.util.Utils;
import com.sun.scenario.effect.impl.prism.PrFilterContext;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.xml.transform.sax.SAXSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Transactional
public class Dao_Profile_Basic_Impl implements Dao_Profile_Basic_I {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Map<String, String> save(ProfileBasic profileBasic) {
        String status = "";
        String id = "";
        try {
            entityManager.persist(profileBasic);
            status = StringUtil.OK;
            id = profileBasic.getId().toString();
        } catch (Exception e) {
            status = StringUtil.FAIL;
            System.out.println("Profile Save Fail!");
            //refactor : separate log file.
            e.printStackTrace();
        }
        Map<String, String> response = new HashMap<>();
        response.put(StringUtil.STATUS, status);
        if (status.equals(StringUtil.OK)) {
            response.put(StringUtil.ID, id);
        } else {
            response.put(StringUtil.ID, StringUtil.NULL);
        }
        //refactor
        System.out.println(response.toString());
        return response;
    }

    @Override
    public Map<String, String> update(ProfileBasic profileBasicNew) {
        Map<String, String> result = new HashMap<>();
        ProfileBasic profileBasicOld = getProfileBasicByUserID(profileBasicNew.getUserId());
        if (profileBasicOld != null) {
            profileBasicOld.setName(profileBasicNew.getName());
            profileBasicOld.setBirthDate(profileBasicNew.getBirthDate());
            profileBasicOld.setCare_of(profileBasicNew.getCare_of());
            profileBasicOld.setGender(profileBasicNew.getGender());
            profileBasicOld.setMaritalStatus(profileBasicNew.getMaritalStatus());
            profileBasicOld.setProfession(profileBasicNew.getProfession());
            profileBasicOld.setBlood_Group(profileBasicNew.getBlood_Group());
            profileBasicOld.setAvailable(profileBasicNew.getAvailable());
            try {
                entityManager.merge(profileBasicOld);
                result.put(StringUtil.STATUS, StringUtil.OK);
            } catch (Exception e) {
                System.out.println("Basic Profile Update Failed!");
                result.put(StringUtil.STATUS, StringUtil.FAIL);
            }
        } else {
            System.out.println("Basic Profile Entity Not Found!");
            result.put(StringUtil.STATUS, StringUtil.FAIL);
        }
        return result;
    }

    @Override
    public Map<String, String> delete(String id) {
        System.out.println("DAO Delete: ");
        Map<String, String> response = new HashMap<>();
        try {
            ProfileBasic profileBasic = entityManager.find(ProfileBasic.class, new Long(id));
            if (profileBasic != null) {
                entityManager.remove(profileBasic);
                response.put(StringUtil.STATUS, StringUtil.OK);
            } else {
                System.out.println("No entity found!");
                response.put(StringUtil.STATUS, StringUtil.FAIL);
            }
        } catch (Exception e) {
            System.out.println("Profile Basic Delete Fail!");
//            e.printStackTrace();
        }
//        System.out.println("response (dao) : " + response.toString());
        return response;
    }

    @Override
    public ProfileBasic findOne(String id) {
        ProfileBasic profileBasic = null;
        try {
            profileBasic = entityManager.find(ProfileBasic.class, Long.parseLong(id));
        } catch (Exception e) {
            System.out.println("Not Found!");
            e.printStackTrace();
        }
        return profileBasic;
    }

    @Override
    public ProfileBasic findOneByUser(String userId) {
        String sql = "SELECT *FROM profilebasic WHERE user_id =" + userId;
        ProfileBasic profileBasic = null;
        List<ProfileBasic> list = entityManager
                .createNativeQuery(sql, ProfileBasic.class)
                .getResultList();
        if (list.size() >= 1) {
            profileBasic = list.get(0);
            //to avoid lazay init error.
            profileBasic.getEmergency_contact().forEach(c -> {
            });
            profileBasic.getPhone_number().forEach(p -> {
            });
//            System.out.println(profileBasic);
        }
        return profileBasic;
    }

    /**
     * better to keep, basicExist and findOneByUser, separate. caue
     * findOneByUser has child init, can be problem, if mulitple times called.
     *
     * @param userId
     * @return
     */
    @Override
    public Map<String, String> basicExist(String userId) {
        Map<String, String> result = new HashMap<>();
        ProfileBasic profileBasic = getProfileBasicByUserID(userId);
        if (profileBasic != null) {
            result.put(StringUtil.STATUS, StringUtil.TRUE);
        } else {
            result.put(StringUtil.STATUS, StringUtil.FALSE);
        }
        return result;
    }

    @Override
    public Map<String, String> updatePresentAddress(Address addressPresentNew, String userID) {
        Map<String, String> result = new HashMap<>();
        ProfileBasic profileBasic = getProfileBasicByUserID(userID);
        if (profileBasic != null) {
            Address addressPresentOld = profileBasic.getAddress_present();
            addressPresentOld.setDivision(addressPresentNew.getDivision());
            addressPresentOld.setDistrict(addressPresentNew.getDistrict());
            addressPresentOld.setUpzilla(addressPresentNew.getUpzilla());
            addressPresentOld.setUnion_ward(addressPresentNew.getUnion_ward());
            addressPresentOld.setStreet_address(addressPresentNew.getStreet_address());
            try {
                entityManager.merge(addressPresentOld);
                result.put(StringUtil.STATUS, StringUtil.OK);
            } catch (Exception e) {
                result.put(StringUtil.STATUS, StringUtil.FAIL);
            }
        } else {
            result.put(StringUtil.STATUS, StringUtil.FAIL);
        }
        return result;
    }

    @Override
    public Map<String, String> updatePermanentAddress(Address addressPermanentNew, String userID) {
        Map<String, String> result = new HashMap<>();
        ProfileBasic profileBasic = getProfileBasicByUserID(userID);
        if (profileBasic != null) {
            Address addressPermanentOld = profileBasic.getAddress_permanent();
            addressPermanentOld.setDivision(addressPermanentNew.getDivision());
            addressPermanentOld.setDistrict(addressPermanentNew.getDistrict());
            addressPermanentOld.setUpzilla(addressPermanentNew.getUpzilla());
            addressPermanentOld.setUnion_ward(addressPermanentNew.getUnion_ward());
            addressPermanentOld.setStreet_address(addressPermanentNew.getStreet_address());
            try {
                entityManager.merge(addressPermanentOld);
                result.put(StringUtil.STATUS, StringUtil.OK);
            } catch (Exception e) {
                result.put(StringUtil.STATUS, StringUtil.FAIL);
            }
        } else {
            result.put(StringUtil.STATUS, StringUtil.FAIL);
        }
        return result;
    }

    @Override
    public Map<String, String> addPhoneNumber(PhoneNumber phoneNumber, String userID) {
        Map<String, String> result = new HashMap<>();
        ProfileBasic profileBasic = getProfileBasicByUserID(userID);
        if (profileBasic != null) {
            List<PhoneNumber> phoneNumbers = profileBasic.getPhone_number();
            phoneNumbers.add(phoneNumber);
            try {
                entityManager.merge(profileBasic);
                result.put(StringUtil.STATUS, StringUtil.OK);
            } catch (Exception e) {
                result.put(StringUtil.STATUS, StringUtil.FAIL);
            }
        } else {
            result.put(StringUtil.STATUS, StringUtil.FAIL);
        }
        return result;
    }

    @Override
    public Map<String, String> deletePhoneNumber(String phoneNumberID, String userID) {
        Map<String, String> result = new HashMap<>();
        ProfileBasic profileBasic = getProfileBasicByUserID(userID);
        if (profileBasic != null) {
            List<PhoneNumber> phoneNumbers = profileBasic.getPhone_number();
            if (phoneNumbers.size() >= 1) {
                phoneNumbers.remove(phoneNumbers
                        .stream()
                        .filter(p -> phoneNumberID.equals(p.getId().toString()))
                        .findAny()
                        .orElse(null));
                try {
                    entityManager.merge(profileBasic);
                    result.put(StringUtil.STATUS, StringUtil.OK);
                } catch (Exception e) {
                    System.out.println("Phone Number Deletion Failed!");
                    result.put(StringUtil.STATUS, StringUtil.FAIL);
                }
            }
        } else {
            result.put(StringUtil.STATUS, StringUtil.FAIL);
        }
        return result;
    }

    public ProfileBasic getProfileBasicByUserID(String userID) {
        String sql = "SELECT *FROM profilebasic WHERE user_id =" + userID;
        List<ProfileBasic> list = entityManager
                .createNativeQuery(sql, ProfileBasic.class)
                .getResultList();
        ProfileBasic profileBasic = null;
        if (list.size() >= 1) {
            profileBasic = list.get(0);
        }
        return profileBasic;
    }

}// class 
