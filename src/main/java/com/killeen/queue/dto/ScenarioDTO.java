package com.killeen.queue.dto;

import java.io.Serializable;

public class ScenarioDTO implements Serializable{

	private String scenarioName;
	private String uuid;
	public String getScenarioName() {
		return scenarioName;
	}
	public void setScenarioName(String scenarioName) {
		this.scenarioName = scenarioName;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	@Override
	public String toString(){
		return uuid + ": " + scenarioName;
	}

}
