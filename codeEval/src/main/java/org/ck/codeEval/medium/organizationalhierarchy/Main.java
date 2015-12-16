package org.ck.codeEval.medium.organizationalhierarchy;

import org.ck.codeChallengeLib.annotation.Solution;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

@Solution(id = 221, name = "Organizational Hierarchy", description = "Recreate the hierarchy tree.", url = "https://www.codeeval.com/open_challenges/221/", category = "Moderate challenges", solved = false)
public class Main
{
	private static Map<String, Employee> employees;

	public static void main(String[] args) throws Exception
	{
		File file = new File(args[0]);
		try (BufferedReader buffer = new BufferedReader(new FileReader(file)))
		{
			String line;
			while ((line = buffer.readLine()) != null)
			{
				line = line.trim();
				String[] arguments = line.split("\\|");

				employees = new HashMap<>();

				for (String argument : arguments)
				{
					String[] names = argument.trim().split("");

					String manager = names[0];
					String subordinate = names[1];

					if (!employees.containsKey(manager))
					{
						employees.put(manager, new Employee(manager));
					}

					if (!employees.containsKey(subordinate))
					{
						employees.put(subordinate, new Employee(subordinate));
					}

					employees.get(manager).addSubordinate(employees.get(subordinate));
					employees.get(subordinate).setHasManager(true);
				}

				List<Employee> topManagers = new ArrayList<>();
				for (Employee employee : employees.values())
				{
					if(!employee.hasManager())
					{
						topManagers.add(employee);
					}
				}
				Collections.sort(topManagers);

				StringBuilder builder = new StringBuilder();
				for (Employee topManager : topManagers)
				{
					builder.append(topManager);
					builder.append(", ");
				}

				if (topManagers.size() > 0)
				{
					builder.deleteCharAt(builder.length() - 1);
					builder.deleteCharAt(builder.length() - 1);
				}
				System.out.println(builder);
			}
		}
	}

	private static class Employee implements Comparable<Employee>
	{
		private String name;
		private List<Employee> subordinates = new ArrayList<>();
		private boolean hasManager = false;

		public Employee(String name)
		{
			this.name = name;
		}

		public void addSubordinate(Employee subordinate)
		{
			this.subordinates.add(subordinate);
		}

		public boolean hasManager()
		{
			return hasManager;
		}

		public void setHasManager(boolean hasManager)
		{
			this.hasManager = hasManager;
		}

		@Override
		public int compareTo(Employee other)
		{
			return this.name.compareTo(other.name);
		}

		@Override
		public String toString()
		{
			Collections.sort(this.subordinates);

			StringBuilder builder = new StringBuilder();
			builder.append(name);

			if (this.subordinates.size() > 0)
			{
				builder.append(" [");

				for (Employee subordinate : this.subordinates)
				{
					builder.append(subordinate.toString());
					builder.append(", ");
				}

				builder.deleteCharAt(builder.length() - 1);
				builder.deleteCharAt(builder.length() - 1);

				builder.append("]");
			}

			return builder.toString();
		}
	}
}