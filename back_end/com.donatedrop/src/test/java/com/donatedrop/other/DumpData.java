package com.donatedrop.other;

import com.donatedrop.geocode.Dao_GeoCode_I;
import com.donatedrop.geocode.models.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DumpData {

    @Autowired
    public static Dao_GeoCode_I dao_geoCode_i;

    static Random r = new Random();

    public static String getHospitalName() {
        String[] hospital = {
                "Apollo Hospitals, Dhaka.",
                "Square Hospital Ltd.",
                "United Hospital Limited.",
                "Bangladesh Institute of Research and Rehabilitation For Diabetes, Endocrine and Metabolic Disorders (BIRDEM).",
                "Ibn-Sina Medical College & Hospital.",
                "National Heart Foundation.",
                "Labaid Cardiac and Specialized Hospital.",
                "Ibrahim Cardiac Hospital & Research Centre.",
                "Forties escorts heart institute & AFC Health, Khulna, Bangladesh.",
                "Islami Bank Hospital.",
                "Isphahani Islamia Eye Institute and Hospital (IIEI&H).",
                "Ad-din Hospital Ltd.",
                "Centre For The Rehabilitation of the Paralyzed (CRP), Savar.",
                "Gastro-liver Hospital And Research Institute.",
                "Green Life Medical College & Hospital.",
                "Holy family Red Crescent Medical College Hospital.",
                "Popular Specialized Hospital Ltd.",
                "Jahirul Islam Medical College Hospital.",
                "Japan- Bangladesh Friendship Hospital.",
                "Delta Hospital Ltd.",
                "Bangladesh Specialized Hospital.",
                "Uttara Crescent Hospital.",
                "Enam Medical College Hospital, Savar.",
                "Marie Stopes Health Clinic.",
                "Bangladesh Medical College Hospital.",
                "Al-Helal Specialist Hospital.",
                "Ayesha Memorial Specialized Hospital.",
                "Anwer Khan Modern Hospital Ltd, Dhaka.",
                "Central Hospital, Dhaka.",
                "Shamorita Hospital, Dhaka.",
                "Lamb Hospital, Dinajpur",
                "Zia Heart Foundation",
                "Khwaja Yunus Ali Medical College and Hospital, Sirajganj.",
                "Jahirul Islam Medical College and Hospital, Kishorganj.",
                "Kumudini Medical College and Hospital, Tangail.",
                "Noorjahan Hospital, Sylhet.",
                "Oasis Hospital Sylhet.",
                "Jalalabad Ragib- Rabeya Medical College, Sylhet.",
                "TMSS Medical College and Hospital, Bogra.",
                "Fuad aL-Khatib Hospital, Cox’s bazaar.",
                "Chattagram Maa-Shishu o General Hospital.",
                "Chittagong Metropolitan Hospital Pvt Lltd.",
                "Community Based Medical College Hospital , Bangladesh (CBMCH,B), Mymensingh.",
                "K Zaman BNSB Eye Hospital, Mymensingh.",
                "Prime Hospital (Pvt) Ltd, Noakhali.",
                "Prime Medical College Hospital, Rangpur.",
                "Ambia memorial hospital, Barisal.",
                "Al-arafa clinic, Rajshahi.",
                "Islami Bank Medical College and Hospital, Rajshahi.",
                "D Hospital Hatemkha ,Rajshahi."};
        return hospital[r.nextInt(hospital.length)];
    }

    public static String getNote() {
        String[] note = {
                "Nice People, but poor",
                "Stupid People, haveing money by no means.",
                "Torrential, got wet, no veichle on the road.",
                "Heavy Jam, came home by their personal car.",
                "Gone by hiring Uber, poor guy wanted to pay but forbided them.",
                "West point, Khulna and Dhaka, Promotta Padma.",
                "Went by Palitina Motor Cycle.",
                "They Do bKash, BDT1000.",
                "Marine Dock Khulna, escorted by navy.",
                "No Comment.",
                "No Need to think about it.",
                "Patinet Diead, after :("
        };
        return note[r.nextInt(note.length)];
    }

    public static String getPatientDescription() {
        String[] patientDescription = {
                "Car Accident, Leg Break",
                "MotorBike Accident, high Speed",
                "MotorBike Accident, Dhaka City, by Leguna.",
                "MotorBike Accident, Khulna City, with cycle.",
                "MotorBike Accident, Barishal City, with Plane.",
                "MotorBike Accident, Shylet City, PickUp van.",
                "MotorBike Accident, Cumilla City, with Treem, serious head injury",
                "covid-19 lockdown patient",
                "Kidney diolosis",
                "Delivary Case",
                "Lucomia"
        };
        return patientDescription[r.nextInt(patientDescription.length)];
    }

    public static String getRefferedBy() {
        String[] ref = {
                "University Junior",
                "University Senior",
                "Faculty",
                "Friends",
                "Uncle",
                "Sister",
                "GUCC Club",
                "Blood Club",
                "FB post",
                "DD post",
        };
        return ref[r.nextInt(ref.length)];
    }

    public static String getLocation() {
        String[] location1 = {"Dhaka", "Khulna", "Rajshahi", "Barishal", "Shylet", "Kustia", "Jessore"};
        String[] location2 = {"Gazipur", "Khulna", "Mymensing", "Rangpur", "Kustia Sadar", "Dumuria", "Mishimil"};
        String[] location3 = {"Ashsoni", "Fultola", "Bagura", "", "Kustia Sadar", "Dumuria", "Mishimil"};
        Random random = new Random();
        String l = location1[random.nextInt(location1.length)] + ", "
                + location2[random.nextInt(location2.length)] + ", "
                + location3[random.nextInt(location3.length)];
        return l;

    }

    public static String getPhoneNumber() {
        String[] operators1 = {"013", "014", "015", "016", "017", "018", "019"};
        String operators2 = Integer.toString(r.nextInt(10)) + Integer.toString(r.nextInt(10));
        String operator = operators1[r.nextInt(operators1.length)] + operators2;

        String number = "";
        for (int x = 0; x < 6; x++) {
            number += Integer.toString(r.nextInt(10));
        }
        return operator + "-" + number;
    }

    public static String getName() {
        String[] title = {"Khan", "Seikh", "Soiad", "Mughul", "Pathan",
                "Mst", "MD", "Dr.", "Eng", "Lion", "Munsi", "Begum", "Khatun", "BiBi",
                "Pddar", "Goldar", "Ahhmed", "Gazi"};
        String[] fName = {
                "Labib", "Abdul Haseeb", "Abdul Kabir", "Abdul Qaadir",
                "Akram", "Aza", "Fujai", "Ghannam", "Ghiyath",
                "Huzayfah", "Jabbar", "Jabr", "Khalil", "Mahbub",
                "Man", "Main", "Mufaddal", "Murabbi", "Nur", "Qanit",
                "Qatadah", "Qays", "Ubayy", "Wadid", "Zaid", "Zayd",
                "Zaim", "Ablah", "Ajeebah", "Ameera", "Anniyah", "Ateefa",
                "Buhaysah", "Buhayyah", "Eshal", "Fiza", "Hayud", "Ibthaj",
                "Kaheesha", "Kashifah", "Mawiyah", "Mehrnaz", "Muruj",
                "Nadirah", "Qudsiyah", "Rihab", "Saadia", "Zuhayra",
                "Aatirah", "Zia", "Ziya"};
        String[] lName = {
                "Laiba", "Manahil", "Mohammed", "Aahil", "Eshal", "Manha", "Aisha", "Aaban",
                "A\'ishah", "Aleena", "Afnan", "A\'shadieeyah", "Amelia", "Rayyan", "Zayan",
                "Rehan", "Maryam", "Aiza", "Amreen", "Usman", "Nimra", "Shaista", "Zoya", "A\'idah"};
        return title[r.nextInt(title.length)] + " " + fName[r.nextInt(fName.length)] + " " + lName[r.nextInt(lName.length)];
    }

    @Test
    public void testAddress() {
        for (int x = 0; x < 50; x++) {
            System.out.println(DumpData.getAddress());
        }
    }

    public static String getAddress() {

        System.out.println("\n" + dao_geoCode_i.toString() + "\n");

        List<DivisionsEngName> divisionsList = dao_geoCode_i.getDivisions();
        int divRand = r.nextInt(divisionsList.size());
        String divID = divisionsList.get(divRand).getId().toString();
        String divName = divisionsList.get(divRand).getName().toString();

        List<DistrictsEngName> districtsEngNameList = dao_geoCode_i.getDistricts(divID);
        int distRand = r.nextInt(districtsEngNameList.size());
        String distID = districtsEngNameList.get(distRand).getId().toString();
        String distName = districtsEngNameList.get(distRand).getName().toString();

        List<UpzillaEngName> upzillaEngNameList = dao_geoCode_i.getUpzillas(distID);
        int upzRand = r.nextInt(upzillaEngNameList.size());
        String upzID = upzillaEngNameList.get(upzRand).getId().toString();
        String upzName = upzillaEngNameList.get(upzRand).getName().toString();

        List<UnionsEngName> unionsEngNameList = dao_geoCode_i.getUnions(upzID);
        int unionRand = r.nextInt(unionsEngNameList.size());
        String unionID = unionsEngNameList.get(unionRand).getId().toString();
        String unionName = unionsEngNameList.get(unionRand).getName().toString();

        return unionName + ", " + upzName + ", " + distName + ", " + divName;
    }


//    public static
}
