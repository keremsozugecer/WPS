/***************************************************************
Copyright � 2011 52�North Initiative for Geospatial Open Source Software GmbH

 Author: Matthias Mueller, TU Dresden
 
 Contact: Andreas Wytzisk, 
 52�North Initiative for Geospatial Open Source SoftwareGmbH, 
 Martin-Luther-King-Weg 24,
 48155 Muenster, Germany, 
 info@52north.org

 This program is free software; you can redistribute it and/or
 modify it under the terms of the GNU General Public License
 version 2 as published by the Free Software Foundation.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; even without the implied WARRANTY OF
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program (see gnu-gpl v2.txt). If not, write to
 the Free Software Foundation, Inc., 59 Temple Place - Suite 330,
 Boston, MA 02111-1307, USA or visit the Free
 Software Foundation�s web page, http://www.fsf.org.

 ***************************************************************/

package org.n52.wps.server.feed.movingcode;

import java.net.URI;
import java.util.StringTokenizer;

public class AlgorithmURL {
	
	private final URI uri;
	private final String publicPath;
	private final String privatePath;
	private static final String SCHEME = "algorithm://";
	private static final String TOKEN = "?";
	
	public AlgorithmURL (String str){
		uri = URI.create(str);
		if (isValid()){
			StringTokenizer st = new StringTokenizer(uri.getSchemeSpecificPart(), TOKEN);
			if (st.hasMoreTokens()){
				publicPath = st.nextToken();
			} else {
				publicPath = null;
			}
			if (st.hasMoreTokens()){
				privatePath = st.nextToken();
			} else {
				privatePath = null;
			}
		} else {
			publicPath = null;
			privatePath = null;
		}
	}
	
	public boolean isValid(){
		if (uri.getScheme().equalsIgnoreCase(SCHEME)){
			return true;
		}
		else return false;
	}
	
	public String getPublicPath(){
		return publicPath;
	}
	
	public String getPrivatePath(){
		return privatePath;
	}
	
}
