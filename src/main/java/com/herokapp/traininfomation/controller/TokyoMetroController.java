package com.herokapp.traininfomation.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.herokapp.traininfomation.entity.TokyoMetroTrainInfomationEntity;
import com.herokapp.traininfomation.entity.TrainInfomationEntity;
import com.herokapp.traininfomation.service.TokyoMetroTrainInfomationServiceImpl;

@Controller
public class TokyoMetroController {
	
	@Autowired
	private TokyoMetroTrainInfomationServiceImpl service;
	
	private static Map<String, String> railwayMap = new HashMap<String, String>() {
	    {
	    	put("odpt.Railway:TokyoMetro.Tozai",      "東西線");
	    	put("odpt.Railway:TokyoMetro.Hibiya",     "日比谷線");
	    	put("odpt.Railway:TokyoMetro.Chiyoda",    "千代田線");
	    	put("odpt.Railway:TokyoMetro.Fukutoshin", "副都心線");
	    	put("odpt.Railway:TokyoMetro.Ginza",      "銀座線");
	    	put("odpt.Railway:TokyoMetro.Hanzomon",   "半蔵門線");
	    	put("odpt.Railway:TokyoMetro.Marunouchi", "丸ノ内線");
	    	put("odpt.Railway:TokyoMetro.Namboku",    "南北線");
	    	put("odpt.Railway:TokyoMetro.Yurakucho",  "有楽町線");
	    }
	};
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView tokyometoro(ModelAndView model) {

		TrainInfomationEntity[] infos = service.getTrainInfomation();
		for (TrainInfomationEntity info : infos) {
			TokyoMetroTrainInfomationEntity metro = (TokyoMetroTrainInfomationEntity) info;
			metro.setRailway(railwayMap.get(metro.getRailway()));
		}

		model.addObject("info", infos);
		model.setViewName("index");
		return model;
	}

}
