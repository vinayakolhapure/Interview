package com.src.practice;

/*
 * Use a DataType Student (name, avg) to return the student with max avg.

Follow this logic.
1. Iterate through the 2D array - get one student array at a time, student[0] is name, student[0] is grade.

2. If student doesn't exist in map (map of String, and ArrayList<Integer>), then
    a. create new integer list and add this student's grade to it,
    b. add student to map.
    c. re-calculate max

3. If student exists,
    a. get student's grades list from map
    b. add current grade to list
    c. add student and updated grades list to map
    d. calculate student's avg
    e. re-calculate max.

4. Return the max student.
 * */

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
