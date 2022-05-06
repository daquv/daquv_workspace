package com.daquv.Connector;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

import org.json.*;
import org.apache.commons.codec.binary.Hex;


import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.*;

public class BaseConnect {
    public HashMap sourcePurposeJob = new HashMap();

    ObjectMapper objectMapper = new ObjectMapper();

    public BaseConnect() {

        StringBuffer json = new StringBuffer();
        json.append("[");
        json.append("{\"id\":\"\", \"name\":\"etc.etc.default_option_title\"},");
        json.append("{\"id\":\"purchase_of_goods\", \"name\":\"etc.etc.purchase_of_goods\"},");
        json.append("{\"id\":\"travel_expenses\", \"name\":\"etc.etc.travel_expenses\"},");
        json.append("{\"id\":\"saving\", \"name\":\"etc.etc.saving\"},");
        json.append("{\"id\":\"cost_of_living\", \"name\":\"etc.etc.cost_of_living\"},");
        json.append("{\"id\":\"personal_purchase\", \"name\":\"etc.etc.personal_purchase\"},");
        json.append("{\"id\":\"business_payment\", \"name\":\"etc.etc.business_payment\"},");
        json.append("{\"id\":\"gift\", \"name\":\"etc.etc.gift\"},");
        json.append("{\"id\":\"others\", \"name\":\"etc.etc.others\"}");
        json.append("]");
        try {
            sourcePurposeJob.put("purpose", objectMapper.readValue(json.toString(), new TypeReference<List<Map<String,String>>>(){}));
        } catch (IOException e) {
            e.printStackTrace();
        }
        json.delete(0, json.capacity());
        json.append("[");
        json.append("{\"id\":\"\", \"name\":\"etc.etc.default_option_title\"},");
        json.append("{\"id\":\"earning_and_pension_income\", \"name\":\"etc.etc.earning_and_pension_income\"},");
        json.append("{\"id\":\"retirement_income\", \"name\":\"etc.etc.retirement_income\"},");
        json.append("{\"id\":\"business_income\", \"name\":\"etc.etc.business_income\"},");
        json.append("{\"id\":\"real_estate_rental_income\", \"name\":\"etc.etc.real_estate_rental_income\"},");
        json.append("{\"id\":\"capital_gains\", \"name\":\"etc.etc.capital_gains\"},");
        json.append("{\"id\":\"financial_incomes\", \"name\":\"etc.etc.financial_incomes\"},");
        json.append("{\"id\":\"inheritance_and_gift\", \"name\":\"etc.etc.inheritance_and_gift\"},");
        json.append("{\"id\":\"property_or_land_income\", \"name\":\"etc.etc.property_or_land_income\"}");
//        json.append("{\"id\":\"others\", \"name\":\"etc.etc.others\"}");
        json.append("]");
        try {
            sourcePurposeJob.put("source", objectMapper.readValue(json.toString(), new TypeReference<List<Map<String,String>>>(){}));
        } catch (IOException e) {
            e.printStackTrace();
        }
        json.delete(0, json.capacity());
        json.append("[");
        json.append("{\"id\":\"\", \"name\":\"etc.etc.default_option_title\"},");
        json.append("{\"id\":\"office_worker\", \"name\":\"etc.etc.office_worker\"},");
        json.append("{\"id\":\"student\", \"name\":\"etc.etc.student\"},");
        json.append("{\"id\":\"private_operator\", \"name\":\"etc.etc.private_operator\"},");
        json.append("{\"id\":\"public_officer\", \"name\":\"etc.etc.public_officer\"},");
        json.append("{\"id\":\"professional_job\", \"name\":\"etc.etc.professional_job\"},");
        json.append("{\"id\":\"freelancer\", \"name\":\"etc.etc.freelancer\"},");
        json.append("{\"id\":\"soldier\", \"name\":\"etc.etc.soldier\"},");
        json.append("{\"id\":\"housewife\", \"name\":\"etc.etc.housewife\"},");
        json.append("{\"id\":\"not_employed\", \"name\":\"etc.etc.not_employed\"}");
//        json.append("{\"id\":\"others\", \"name\":\"etc.etc.others\"}");
        json.append("]");
        try {
            sourcePurposeJob.put("job", objectMapper.readValue(json.toString(), new TypeReference<List<Map<String,String>>>(){}));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setSourcePurposeJob() {
        ObjectMapper objectMapper = new ObjectMapper();
        StringBuffer json = new StringBuffer();
        json.append("[");
        json.append("{\"id\":\"\", \"name\":\"etc.etc.default_option_title\"},");
        json.append("{\"id\":\"purchase_of_goods\", \"name\":\"etc.etc.purchase_of_goods\"},");
        json.append("{\"id\":\"travel_expenses\", \"name\":\"etc.etc.travel_expenses\"},");
        json.append("{\"id\":\"saving\", \"name\":\"etc.etc.saving\"},");
        json.append("{\"id\":\"cost_of_living\", \"name\":\"etc.etc.cost_of_living\"},");
        json.append("{\"id\":\"personal_purchase\", \"name\":\"etc.etc.personal_purchase\"},");
        json.append("{\"id\":\"business_payment\", \"name\":\"etc.etc.business_payment\"},");
        json.append("{\"id\":\"gift\", \"name\":\"etc.etc.gift\"},");
        json.append("{\"id\":\"others\", \"name\":\"etc.etc.others\"}");
        json.append("]");
        try {
            sourcePurposeJob.put("purpose", objectMapper.readValue(json.toString(), new TypeReference<List<Map<String,String>>>(){}));
        } catch (IOException e) {
            e.printStackTrace();
        }
        json.delete(0, json.capacity());
        json.append("[");
        json.append("{\"id\":\"\", \"name\":\"etc.etc.default_option_title\"},");
        json.append("{\"id\":\"earning_and_pension_income\", \"name\":\"etc.etc.earning_and_pension_income\"},");
        json.append("{\"id\":\"retirement_income\", \"name\":\"etc.etc.retirement_income\"},");
        json.append("{\"id\":\"business_income\", \"name\":\"etc.etc.business_income\"},");
        json.append("{\"id\":\"real_estate_rental_income\", \"name\":\"etc.etc.real_estate_rental_income\"},");
        json.append("{\"id\":\"capital_gains\", \"name\":\"etc.etc.capital_gains\"},");
        json.append("{\"id\":\"financial_incomes\", \"name\":\"etc.etc.financial_incomes\"},");
        json.append("{\"id\":\"inheritance_and_gift\", \"name\":\"etc.etc.inheritance_and_gift\"},");
        json.append("{\"id\":\"property_or_land_income\", \"name\":\"etc.etc.property_or_land_income\"}");
//        json.append("{\"id\":\"others\", \"name\":\"etc.etc.others\"}");
        json.append("]");
        try {
            sourcePurposeJob.put("source", objectMapper.readValue(json.toString(), new TypeReference<List<Map<String,String>>>(){}));
        } catch (IOException e) {
            e.printStackTrace();
        }
        json.delete(0, json.capacity());
        json.append("[");
        json.append("{\"id\":\"\", \"name\":\"etc.etc.default_option_title\"},");
        json.append("{\"id\":\"office_worker\", \"name\":\"etc.etc.office_worker\"},");
        json.append("{\"id\":\"student\", \"name\":\"etc.etc.student\"},");
        json.append("{\"id\":\"private_operator\", \"name\":\"etc.etc.private_operator\"},");
        json.append("{\"id\":\"public_officer\", \"name\":\"etc.etc.public_officer\"},");
        json.append("{\"id\":\"professional_job\", \"name\":\"etc.etc.professional_job\"},");
        json.append("{\"id\":\"freelancer\", \"name\":\"etc.etc.freelancer\"},");
        json.append("{\"id\":\"soldier\", \"name\":\"etc.etc.soldier\"},");
        json.append("{\"id\":\"housewife\", \"name\":\"etc.etc.housewife\"},");
        json.append("{\"id\":\"not_employed\", \"name\":\"etc.etc.not_employed\"}");
//        json.append("{\"id\":\"others\", \"name\":\"etc.etc.others\"}");
        json.append("]");
        try {
            sourcePurposeJob.put("job", objectMapper.readValue(json.toString(), new TypeReference<List<Map<String,String>>>(){}));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public JacksonConverterFactory buildJacksonConverter(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return JacksonConverterFactory.create(objectMapper);
    }

    protected GsonConverterFactory buildGsonConverter() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson myGson = gsonBuilder.create();
        return GsonConverterFactory.create(myGson);
    }

    public String getBase64Encoder(String plainText) {
        try {
            Base64.Encoder encoder = Base64.getEncoder();
            String encodedString = encoder.encodeToString(plainText.getBytes("UTF-8"));
            return encodedString;
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getBase64Encoder(byte[] plainText) {
        try {
            Base64.Encoder encoder = Base64.getEncoder();
            String encodedString = encoder.encodeToString(plainText);
            return encodedString;
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getBase64Decoder(String base64Text) {
        try {
            Base64.Decoder decoder = Base64.getDecoder();
            String decodedString = new String(decoder.decode(base64Text), "UTF-8");
            return decodedString;
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public byte[] hashHmac(String plainText, String key, String algorithm, boolean hex) throws Exception {
        Base64.Encoder encoder = Base64.getEncoder();
        Mac mac = Mac.getInstance(algorithm);
        SecretKeySpec secret = new SecretKeySpec(key.getBytes("UTF-8"), mac.getAlgorithm());
        mac.init(secret);

        if(hex){
            return mac.doFinal(plainText.getBytes("UTF-8"));
        }
        return new Hex().encode(mac.doFinal(plainText.getBytes("UTF-8")));
    }

    public String getMD5(String str) throws Exception {
        String MD5 = "";
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(str.getBytes());
        byte byteData[] = md.digest();
        StringBuffer sb = new StringBuffer();
        for(int i = 0 ; i < byteData.length ; i++){
            sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }

    private String encryptSks(String plainText, String sksKey, String salt){
        try {
            char[] sksKeyChars = sksKey.toCharArray();

            PBEKeySpec spec = new PBEKeySpec( sksKeyChars, salt.getBytes(StandardCharsets.UTF_8), 1024, 256 );
            SecretKeyFactory key = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] hashedKey = key.generateSecret(spec).getEncoded();

            SecretKeySpec secretKey = new SecretKeySpec(hashedKey, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, new IvParameterSpec(salt.getBytes(StandardCharsets.UTF_8)));
            return new String(DatatypeConverter.printBase64Binary(cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8))));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    private String decryptSks(String encText, String sksKey, String salt){
        try {
            char[] sksKeyChars = sksKey.toCharArray();

            PBEKeySpec spec = new PBEKeySpec( sksKeyChars, salt.getBytes(StandardCharsets.UTF_8), 1024, 256 );
            SecretKeyFactory key = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] hashedKey = key.generateSecret(spec).getEncoded();

            SecretKeySpec secretKey = new SecretKeySpec(hashedKey, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(salt.getBytes(StandardCharsets.UTF_8)));
            return new String(cipher.doFinal(DatatypeConverter.parseBase64Binary(encText)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public JSONObject objectToMap(Object obj) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map map_params = objectMapper.readValue(objectMapper.writeValueAsString(obj), new TypeReference<Map>(){});
            JSONObject params = objectMapper.readValue(objectMapper.writeValueAsString(map_params), new TypeReference<JSONObject>(){});
            return params;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

   


}
