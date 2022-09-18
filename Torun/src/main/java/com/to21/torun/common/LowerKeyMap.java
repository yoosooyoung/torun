package com.to21.torun.common;

import org.apache.commons.collections4.map.ListOrderedMap;
import org.apache.commons.lang3.StringUtils;

@SuppressWarnings("rawtypes")
public class LowerKeyMap extends ListOrderedMap {

	private static final long serialVersionUID = -7700790403928325865L;
	
	@SuppressWarnings("unchecked")
	public Object put(Object key, Object value) {
		
		return super.put(StringUtils.lowerCase((String)key),value);
	}
	
}
