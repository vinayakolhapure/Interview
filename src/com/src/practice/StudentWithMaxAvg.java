package com.src.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.OptionalDouble;

public class StudentWithMaxAvg {
	
	private static class Student {
		public String name;
		public Double avg;
		
		Student(String n, Double a) {
			name = n;
			avg = a;
		}
	}
	
	public static void main(String[] args) {
		String[][] s = { { "Jerry", "65" }, { "Bob", "91" }, { "Jerry", "23" }, { "Eric", "83" }, };

		Student top = studentWithMaxAvg(s);
		System.out.println(top.name + ", avg: " + top.avg);
	}

	private static Student studentWithMaxAvg(String[][] s) {
		
		Map<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
		
		Student maxStudent = new Student("",(double)Integer.MIN_VALUE);
		
		for(String[] student : s) {
			if(!map.containsKey(student[0])) {
				String name = student[0];
				int grade = Integer.parseInt(student[1]);
				
				ArrayList<Integer> grades = new ArrayList<Integer>(); //create new list
				grades.add(grade);
				map.put(name, grades); //add to map to calc avg
				
				Student curr = new Student(name, (double) grade);
				
				maxStudent = reCalcMax(maxStudent, curr); //re calculate the avg and maintain to compare with next student entry.
				
			} else {
				String name = student[0];
				int grade = Integer.parseInt(student[1]);
				
				ArrayList<Integer> grades = map.get(name);
				grades.add(grade);
				map.put(name, grades);
				
				double avg = getAvgForStudent(grades);
				
				Student curr = new Student(name, avg);
				
				maxStudent = reCalcMax(maxStudent, curr);
			}
		}
		return maxStudent;
	}

	private static double getAvgForStudent(ArrayList<Integer> grades) {
		OptionalDouble avg = grades.stream().mapToDouble(i->i).average();
		
		return avg.getAsDouble();
	}

	private static Student reCalcMax(Student max, Student curr) {
		
		if(curr.avg > max.avg) {
			return curr;
		}
		return max;
	}
}
