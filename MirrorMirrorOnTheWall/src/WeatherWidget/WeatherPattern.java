/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2017 Oracle and/or its affiliates. All rights reserved.
 *
 * Oracle and Java are registered trademarks of Oracle and/or its affiliates.
 * Other names may be trademarks of their respective owners.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common
 * Development and Distribution License("CDDL") (collectively, the
 * "License"). You may not use this file except in compliance with the
 * License. You can obtain a copy of the License at
 * http://www.netbeans.org/cddl-gplv2.html
 * or nbbuild/licenses/CDDL-GPL-2-CP. See the License for the
 * specific language governing permissions and limitations under the
 * License.  When distributing the software, include this License Header
 * Notice in each file and include the License file at
 * nbbuild/licenses/CDDL-GPL-2-CP.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the GPL Version 2 section of the License file that
 * accompanied this code. If applicable, add the following below the
 * License Header, with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 * If you wish your version of this file to be governed by only the CDDL
 * or only the GPL Version 2, indicate your decision by adding
 * "[Contributor] elects to include this software in this distribution
 * under the [CDDL or GPL Version 2] license." If you do not indicate a
 * single choice of license, a recipient has the option to distribute
 * your version of this file under either the CDDL, the GPL Version 2 or
 * to extend the choice of license to its licensees as provided above.
 * However, if you add GPL Version 2 code and therefore, elected the GPL
 * Version 2 license, then the option applies only if the new code is
 * made subject to such option by the copyright holder.
 *
 * Contributor(s):
 */
package WeatherWidget;

/**
 *
 * @author melmulcahy
 */
public enum WeatherPattern{
	SUNNY(1), 
        MOSTLY_SUNNY(2), 
        PARTLY_SUNNY(3), 
        INTERMITTENT_CLOUDS(4),
	HAZY_SUNSHINE(5), 
        MOSTLY_CLOUDY(6), 
        CLOUDY(7), 
        DREARY(8),
	FOG(11), 
        SHOWERS(12), 
        MOSTLY_CLOUDY_SHOWERS(13), 
        PARTLY_SUNNY_SHOWERS(14),
	T_STORMS(15), 
        MOSTLY_CLOUDY_T_STORMS(16), 
        PARTLY_CLOUDY_T_STORMS(17), 
        RAIN(18),
	FLURRIES(19), 
        MOSTLY_CLOUDY_FLURRIES(20), 
        PARTLY_SUNNY_FLURRIES(21), 
        SNOW(22),
	MOSTLY_CLOUDY_SNOW(23), 
        ICE(24), 
        SLEET(25), 
        FREEZING_RAIN(26),
	RAIN_AND_SNOW(29), 
        HOT(30), 
        COLD(31), 
        WINDY(32),
        CLEAR(33), 
        MOSTLY_CLEAR(34), 
        PARTLY_CLEAR(35), 
        INTERMITTMENT_CLOUDS_NIGHT(36),
        HAZY_MOONLIGHT(37), 
        MOSTLY_CLOUDY_NIGHT(38), 
        PARTLY_CLOUDY_SHOWERS_NIGHT(39),
        MOSTLY_CLOUDY_SHOWERS_NIGHT(40), 
        PARTLY_CLOUDY_T_STORMS_NIGHT(41), 
        MOSTLY_CLOUDY_T_STORMS_NIGHT(42), 
        MOSTLY_CLOUDY_FLURRIES_NIGHT(43),
        MOSTLY_CLOUDY_SNOW_NIGHT(44);
        
	private final int patternID;
	private WeatherPattern(int patternID){
		this.patternID = patternID;
	}
        
        public int getPatternID(){
            return this.patternID;
        }
        
        @Override
        public String toString()
        {
            return ((Integer)this.patternID).toString();
        }
}
