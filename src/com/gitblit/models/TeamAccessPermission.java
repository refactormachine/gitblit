/*
 * Copyright 2012 gitblit.com.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.gitblit.models;

import java.io.Serializable;

import com.gitblit.Constants.AccessPermission;

/**
 * Represents a Team-AccessPermission tuple.
 * 
 * @author James Moger
 */
public class TeamAccessPermission implements Serializable, Comparable<TeamAccessPermission> {

	private static final long serialVersionUID = 1L;

	public String team;
	public AccessPermission permission;

	public TeamAccessPermission() {
	}
	
	public TeamAccessPermission(String team, AccessPermission permission) {
		this.team = team;
		this.permission = permission;
	}
	
	@Override
	public int compareTo(TeamAccessPermission p) {
		return team.compareTo(p.team);
	}
	
	@Override
	public String toString() {
		return permission.asRole("@" + team);
	}
}