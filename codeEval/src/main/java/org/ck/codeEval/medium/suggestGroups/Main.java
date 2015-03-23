package org.ck.codeEval.medium.suggestGroups;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.ck.codeChallengeLib.annotation.Solution;

@Solution(id = 165, name = "Suggest Groups", description = "Help your friends to join groups.", url = "https://www.codeeval.com/open_challenges/165/", category = "Moderate callenges")
public class Main
{
	public static void main(String[] args) throws Exception
	{
		File file = new File(args[0]);
		try (BufferedReader buffer = new BufferedReader(new FileReader(file)))
		{
			Map<String, Person> people = new HashMap<>();

			String line;
			while ((line = buffer.readLine()) != null)
			{
				line = line.trim();
				String[] arguments = line.split(":");

				if (arguments.length == 3)
				{
					people.put(arguments[0], (new Main()).new Person(arguments[0], arguments[1].split(","), arguments[2].split(",")));
				}
				else if (arguments.length == 2)
				{
					people.put(arguments[0], (new Main()).new Person(arguments[0], arguments[1].split(","), null));
				}
			}

			for (Person person : people.values())
			{
				person.findFriends(people);
			}

			Map<Person, Set<String>> suggestions = new TreeMap<>();

			for (Person person : people.values())
			{
				Map<String, Integer> groupCount = new HashMap<>();

				for (Person friend : person.getFriends())
				{
					for (String group : friend.getGroups())
					{
						if (groupCount.containsKey(group))
						{
							groupCount.put(group, groupCount.get(group) + 1);
						}
						else
						{
							groupCount.put(group, 1);
						}
					}
				}

				Set<String> suggestionsForPerson = new TreeSet<>();
				int friends = person.getFriends().size();

				for (String group : groupCount.keySet())
				{
					if (groupCount.get(group) >= friends - groupCount.get(group))
					{
						suggestionsForPerson.add(group);
					}
				}

				for (String group : person.getGroups())
				{
					suggestionsForPerson.remove(group);
				}

				if (suggestionsForPerson.size() > 0)
				{
					suggestions.put(person, suggestionsForPerson);
				}
			}

			
			for (Person person : suggestions.keySet())
			{
				StringBuilder builder = new StringBuilder();
				builder.append(person.getName() + ":");
				
				for (String group : suggestions.get(person))
				{
					builder.append(group + ",");
				}
				
				if (builder.length() > 0)
				{
					builder.deleteCharAt(builder.length() - 1);
				}
				
				System.out.println(builder);
			}
		}
	}

	private class Person implements Comparable<Person>
	{
		private String name;
		private Set<String> groups = new TreeSet<>();

		private Set<String> friendNames = new TreeSet<>();
		private Set<Person> friends = new TreeSet<>();

		public Person(String name, String[] friends, String[] groups)
		{
			this.name = name;

			if (friends != null)
			{
				for (String friend : friends)
				{
					this.friendNames.add(friend);
				}
			}

			if (groups != null)
			{
				for (String group : groups)
				{
					this.groups.add(group);
				}
			}
		}

		public Set<String> getGroups()
		{
			return this.groups;
		}

		public Set<Person> getFriends()
		{
			return this.friends;
		}

		public void findFriends(Map<String, Person> people)
		{
			for (String friendName : this.friendNames)
			{
				Person friend = people.get(friendName);

				this.friends.add(friend);
				friend.addFriend(this);
			}
		}

		public void addFriend(Person friend)
		{
			this.friends.add(friend);
		}

		public String getName()
		{
			return this.name;
		}

		@Override
		public boolean equals(Object object)
		{
			if (object instanceof Person)
			{
				Person person = (Person) object;

				return person.getName().equals(this.getName());
			}

			return false;
		}

		@Override
		public int hashCode()
		{
			return this.name.hashCode();
		}

		@Override
		public int compareTo(Person person)
		{
			return this.name.compareTo(person.getName());
		}
	}
}