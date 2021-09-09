package com.voice;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;

@SpringBootApplication
public class VoiceAssistantApplication {

	public static void main(String[] args) {
		SpringApplication.run(VoiceAssistantApplication.class, args);
		
		
		
			
			Configuration config = new Configuration();
			
			config.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
			config.setDictionaryPath("src\\main\\resources\\7276.dic");
			config.setLanguageModelPath("src\\main\\resources\\7276.lm");
			
			try {
				LiveSpeechRecognizer speech = new LiveSpeechRecognizer(config);
				speech.startRecognition(true);
				
				SpeechResult speechResult = null;
				
				while ((speechResult = speech.getResult()) != null) {
					String voiceCommand = speechResult.getHypothesis();
					System.out.println("Voice Command is " + voiceCommand);
					
					if (voiceCommand.equalsIgnoreCase("Open Google")) {
						Runtime.getRuntime().exec("cmd.exe /c start chrome www.google.com");
					} else if (voiceCommand.equalsIgnoreCase("Exit Google")) {
						Runtime.getRuntime().exec("cmd.exe /c TASKKILL /IM chrome.exe");
					}
					else if (voiceCommand.equalsIgnoreCase("Open Facebook")) {
						Runtime.getRuntime().exec("cmd.exe /c start chrome www.facebook.com");
					}
					else if (voiceCommand.equalsIgnoreCase("Exit Facebook")) {
						Runtime.getRuntime().exec("cmd.exe /c TASKKILL /IM chrome.exe");
					}
					else if (voiceCommand.equalsIgnoreCase("Open Spring")) {
						Runtime.getRuntime().exec("cmd.exe /c start chrome https://start.spring.io/");
					}
					else if (voiceCommand.equalsIgnoreCase("Exit Spring")) {
						Runtime.getRuntime().exec("cmd.exe /c TASKKILL /IM chrome.exe");
					}
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

	
}
