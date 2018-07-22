package com;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadFromFile {

	public static void main(String[] args) {
		
		File inputFile = new File(new StringBuilder("C:").append(File.separator)
				.append("TEMP").append(File.separator).append("sample.txt").toString());
		String inputFilePathStr = new StringBuilder("C:").append(File.separator)
				.append("TEMP").append(File.separator).append("sample.txt").toString();
		
		File outputFile1 = new File(new StringBuilder("C:").append(File.separator)
				.append("TEMP").append(File.separator).append("sample1.txt").toString());

		File outputFile2 = new File(new StringBuilder("C:").append(File.separator)
				.append("TEMP").append(File.separator).append("sample2.txt").toString());
		
		String outputFile3 = new StringBuilder("C:").append(File.separator)
				.append("TEMP").append(File.separator).append("sample3.txt").toString();
		
		usingFileInputStream(inputFile, outputFile1);
		System.out.println("$$$$$$$$$$");
		usingBufferedReader(inputFile, outputFile2);
		System.out.println("$$$$$$$$$$");
		usingJDK7File(inputFilePathStr, outputFile3);
	}
	
	public static void usingFileInputStream(File inputFile, File outputFile1) {
		
		
		try (FileInputStream fis = new FileInputStream(inputFile);
			 FileOutputStream fos = new FileOutputStream(outputFile1)	) {
				
			byte[] buffer = new byte[1024];
			while(fis.read(buffer) != -1) {
				
				System.out.println(new String(buffer));
				fos.write(buffer);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void usingBufferedReader(File inputFile, File outputFile2) {
		
		 try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
			  BufferedWriter brw = new BufferedWriter(new FileWriter(outputFile2))) {
				
			String s = null;
			while ((s = br.readLine()) != null) {
				
				System.out.println(s);
				brw.write(s);
				brw.newLine();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void usingJDK7File(String inputFilePathStr, String outputFile3) {
	    
		Path inputFilePath = Paths.get(inputFilePathStr);
		Path outFilePath = Paths.get(outputFile3);
	    
	    try (BufferedReader reader = Files.newBufferedReader(inputFilePath);
	    	BufferedWriter writer = Files.newBufferedWriter(outFilePath)) {
	    	
	        String line = null;
	        while ((line = reader.readLine()) != null) {
	        	
	            System.out.println(line);
	            writer.write(line);
	            writer.newLine();
	        }
	    } catch (IOException e) {
			e.printStackTrace();
		}
	}
}
