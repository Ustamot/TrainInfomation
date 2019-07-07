package com.herokapp.traininfomation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.herokapp.traininfomation.entity.TokyoMetroTrainInfomationEntity;
import com.herokapp.traininfomation.entity.TrainInfomationEntity;


@Service
public class TokyoMetroTrainInfomationServiceImpl implements TrainInfomationService {
	
	static private final String URL = "https://api.tokyometroapp.jp/api/v2/datapoints?rdf:type=odpt:TrainInformation&acl:consumerKey=b26ce611b4195e1ca43197c4ca9bc19082afe5b93a61bf4cb60036346f2cd797";

	@Autowired
	private RestTemplate restTemplate;
	
    public TokyoMetroTrainInfomationServiceImpl () {
		
	}
	
	public TrainInfomationEntity[] getTrainInfomation() {
		
		//restTemplate = new RestTemplate();
		return restTemplate.getForObject(URL, TokyoMetroTrainInfomationEntity[].class); //, railway);
	}
	
}
