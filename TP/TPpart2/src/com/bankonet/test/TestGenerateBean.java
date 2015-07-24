package com.bankonet.test;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.bankonet.model.*;


public class TestGenerateBean {

//	public static void main (String[] args){
////		GenerateBeansTest gb = new Generate...
////		
////	}
//	
//	
//	
//	public void generateBeanInstance(Client client){
//		Map clientData = getClientData();
//		Set clientDataKeys= clientData.keySet();
//		Iterator clientdataKeysIte = clientDataKeys.iterator();
//		try{
//			Class clientClass = client.getClass();
//			while (clientdataKeysIte.hasNext()){
//				String key = (String) clientdataKeysIte.next();
//				Class[] parametersType = new Class[]{clientData.get(key).getClass()};
//				
//				String methodName = "set"+key;
//				Method setterMethod = clientClass.getMethod(methodName, parametersType);
//				
//			}Object[] arguments = new Object[] {getClientData().get(key)};
//			System.out.println("invocation de la méthode trouvee ("+setterMethod+")...");
//			setterMethod.invoke(client, arguments);
//		}
//		
//		
//	}
//	
//	public Map getClientData(){
//		Map dataBeans = new HashMap();
//		dataBeans.put("identifiant", new Integer(43));
//		dataBeans.put("nom", "Aymé");
//		dataBeans.put("prenom", "Marcel");
//		return dataBeans;
//	}
}
