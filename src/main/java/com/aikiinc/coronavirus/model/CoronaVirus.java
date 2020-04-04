package com.aikiinc.coronavirus.model;

public class CoronaVirus {
	private int fips;
	private String region;
	private String province;
	private String countyBorough;
	private String lastUpdate;
	private String latitude;
	private String longitude;
	private String confirmed;
	private String deaths;
	private String recovered;
	private String active;
	private String combinedKey;

	public int getFips() {
		return fips;
	}

	public void setFips(int fips) {
		this.fips = fips;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCountyBorough() {
		return countyBorough;
	}

	public void setCountyBorough(String county_borough) {
		this.countyBorough = county_borough;
	}

	public String getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(String confirmed) {
		this.confirmed = confirmed;
	}

	public String getRecovered() {
		return recovered;
	}

	public void setRecovered(String recovered) {
		this.recovered = recovered;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getCombinedKey() {
		return combinedKey;
	}

	public void setCombinedKey(String combinedKey) {
		this.combinedKey = combinedKey;
	}

	public String getDeaths() {
		return deaths;
	}

	public void setDeaths(String deaths) {
		this.deaths = deaths;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((active == null) ? 0 : active.hashCode());
		result = prime * result + ((combinedKey == null) ? 0 : combinedKey.hashCode());
		result = prime * result + ((confirmed == null) ? 0 : confirmed.hashCode());
		result = prime * result + ((countyBorough == null) ? 0 : countyBorough.hashCode());
		result = prime * result + ((deaths == null) ? 0 : deaths.hashCode());
		result = prime * result + fips;
		result = prime * result + ((lastUpdate == null) ? 0 : lastUpdate.hashCode());
		result = prime * result + ((latitude == null) ? 0 : latitude.hashCode());
		result = prime * result + ((longitude == null) ? 0 : longitude.hashCode());
		result = prime * result + ((province == null) ? 0 : province.hashCode());
		result = prime * result + ((recovered == null) ? 0 : recovered.hashCode());
		result = prime * result + ((region == null) ? 0 : region.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CoronaVirus other = (CoronaVirus) obj;
		if (active == null) {
			if (other.active != null)
				return false;
		} else if (!active.equals(other.active))
			return false;
		if (combinedKey == null) {
			if (other.combinedKey != null)
				return false;
		} else if (!combinedKey.equals(other.combinedKey))
			return false;
		if (confirmed == null) {
			if (other.confirmed != null)
				return false;
		} else if (!confirmed.equals(other.confirmed))
			return false;
		if (countyBorough == null) {
			if (other.countyBorough != null)
				return false;
		} else if (!countyBorough.equals(other.countyBorough))
			return false;
		if (deaths == null) {
			if (other.deaths != null)
				return false;
		} else if (!deaths.equals(other.deaths))
			return false;
		if (fips != other.fips)
			return false;
		if (lastUpdate == null) {
			if (other.lastUpdate != null)
				return false;
		} else if (!lastUpdate.equals(other.lastUpdate))
			return false;
		if (latitude == null) {
			if (other.latitude != null)
				return false;
		} else if (!latitude.equals(other.latitude))
			return false;
		if (longitude == null) {
			if (other.longitude != null)
				return false;
		} else if (!longitude.equals(other.longitude))
			return false;
		if (province == null) {
			if (other.province != null)
				return false;
		} else if (!province.equals(other.province))
			return false;
		if (recovered == null) {
			if (other.recovered != null)
				return false;
		} else if (!recovered.equals(other.recovered))
			return false;
		if (region == null) {
			if (other.region != null)
				return false;
		} else if (!region.equals(other.region))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CoronaVirus [fips=");
		builder.append(fips);
		builder.append(", region=");
		builder.append(region);
		builder.append(", province=");
		builder.append(province);
		builder.append(", county_borough=");
		builder.append(countyBorough);
		builder.append(", lastUpdate=");
		builder.append(lastUpdate);
		builder.append(", latitude=");
		builder.append(latitude);
		builder.append(", longitude=");
		builder.append(longitude);
		builder.append(", confirmed=");
		builder.append(confirmed);
		builder.append(", deaths=");
		builder.append(deaths);
		builder.append(", recovered=");
		builder.append(recovered);
		builder.append(", active=");
		builder.append(active);
		builder.append(", combinedKey=");
		builder.append(combinedKey);
		builder.append("]");
		return builder.toString();
	}

}