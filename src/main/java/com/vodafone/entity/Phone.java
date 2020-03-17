package com.vodafone.entity;

public class Phone {

	private String brand;
	private String model;
	private String network;
	private String os;
	private String mainCamera;
	private String selfieCamera;
	private String memory;
	private String sound;
	private String sensors;
	private String battery;
	private String launchDate;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getMainCamera() {
		return mainCamera;
	}

	public void setMainCamera(String camera) {
		this.mainCamera = camera;
	}

	public String getLaunchDate() {
		return launchDate;
	}

	public void setLaunchDate(String launchDate) {
		this.launchDate = launchDate;
	}

	public String getSelfieCamera() {
		return selfieCamera;
	}

	public void setSelfieCamera(String selfieCamera) {
		this.selfieCamera = selfieCamera;
	}

	public String getMemory() {
		return memory;
	}

	public void setMemory(String memory) {
		this.memory = memory;
	}

	public String getSound() {
		return sound;
	}

	public void setSound(String sound) {
		this.sound = sound;
	}

	public String getSensors() {
		return sensors;
	}

	public void setSensors(String sensors) {
		this.sensors = sensors;
	}

	public String getBattery() {
		return battery;
	}

	public void setBattery(String battery) {
		this.battery = battery;
	}

	@Override
	public String toString() {
		return "brand: " + brand + "\nmodel: " + model + "\nnetwork: " + network + "\nos: " + os + "\nmain camera: "
				+ mainCamera + "\nselfie camera: " + selfieCamera + "\nmemory: \n" + memory + "\nsound: " + sound
				+ "\nsensors: " + sensors + "\nbattery: " + battery + "\nlaunch date: " + launchDate;
	}
}
