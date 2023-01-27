/*
 * This source file was generated to Arke Soluciones by AKSGen software
 * 
 * For more information please visit http://www.arkesol.mx
 */
package com.solucionesenjambre.tindertieso.aks.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * This automatically generated class represents the DTO for database object <pre>Tracks DAO</pre>.
 * 
 * @author AKSGen
 * @author Rafael Gallardo
 * 
 * @version 0.0.1, 2023-01-24
 *
 */
public class Tracks implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 20230124000000853L;

	/**
	 * This attribute maps to the column track_id in the tracks table/view/sp
	 */
	protected String trackId;

	/**
	 * This attribute maps to the column danceability in the tracks table/view/sp
	 */
	protected int danceability;

	/**
	 * This attribute maps to the column energy in the tracks table/view/sp
	 */
	protected int energy;

	/**
	 * This attribute maps to the column song_key in the tracks table/view/sp
	 */
	protected int songKey;

	/**
	 * This attribute maps to the column loudness in the tracks table/view/sp
	 */
	protected int loudness;

	/**
	 * This attribute maps to the column mode in the tracks table/view/sp
	 */
	protected int mode;

	/**
	 * This attribute maps to the column speechiness in the tracks table/view/sp
	 */
	protected int speechiness;

	/**
	 * This attribute maps to the column acousticness in the tracks table/view/sp
	 */
	protected int acousticness;

	/**
	 * This attribute maps to the column instrumentalness in the tracks table/view/sp
	 */
	protected int instrumentalness;

	/**
	 * This attribute maps to the column liveness in the tracks table/view/sp
	 */
	protected int liveness;

	/**
	 * This attribute maps to the column valence in the tracks table/view/sp
	 */
	protected int valence;

	/**
	 * This attribute maps to the column tempo in the tracks table/view/sp
	 */
	protected int tempo;

	/**
	 * This attribute maps to the column time_signature in the tracks table/view/sp
	 */
	protected int timeSignature;

	/**
	 * Method 'Tracks'
	 * 
	 */
	public Tracks()
	{
	}

	/**
	 * Method 'getTrackId()'
	 * 
	 * @return String
	 */
	public String getTrackId()
	{
		return trackId;
	}

	/**
	 * Method 'setTrackId'
	 *
	 * @param trackId
	 */
	public void setTrackId(String trackId)
	{
		this.trackId = trackId;
	}

	/**
	 * Method 'getDanceability()'
	 * 
	 * @return int
	 */
	public int getDanceability()
	{
		return danceability;
	}

	/**
	 * Method 'setDanceability'
	 *
	 * @param danceability
	 */
	public void setDanceability(int danceability)
	{
		this.danceability = danceability;
	}

	/**
	 * Method 'getEnergy()'
	 * 
	 * @return int
	 */
	public int getEnergy()
	{
		return energy;
	}

	/**
	 * Method 'setEnergy'
	 *
	 * @param energy
	 */
	public void setEnergy(int energy)
	{
		this.energy = energy;
	}

	/**
	 * Method 'getSongKey()'
	 * 
	 * @return int
	 */
	public int getSongKey()
	{
		return songKey;
	}

	/**
	 * Method 'setSongKey'
	 *
	 * @param songKey
	 */
	public void setSongKey(int songKey)
	{
		this.songKey = songKey;
	}

	/**
	 * Method 'getLoudness()'
	 * 
	 * @return int
	 */
	public int getLoudness()
	{
		return loudness;
	}

	/**
	 * Method 'setLoudness'
	 *
	 * @param loudness
	 */
	public void setLoudness(int loudness)
	{
		this.loudness = loudness;
	}

	/**
	 * Method 'getMode()'
	 * 
	 * @return int
	 */
	public int getMode()
	{
		return mode;
	}

	/**
	 * Method 'setMode'
	 *
	 * @param mode
	 */
	public void setMode(int mode)
	{
		this.mode = mode;
	}

	/**
	 * Method 'getSpeechiness()'
	 * 
	 * @return int
	 */
	public int getSpeechiness()
	{
		return speechiness;
	}

	/**
	 * Method 'setSpeechiness'
	 *
	 * @param speechiness
	 */
	public void setSpeechiness(int speechiness)
	{
		this.speechiness = speechiness;
	}

	/**
	 * Method 'getAcousticness()'
	 * 
	 * @return int
	 */
	public int getAcousticness()
	{
		return acousticness;
	}

	/**
	 * Method 'setAcousticness'
	 *
	 * @param acousticness
	 */
	public void setAcousticness(int acousticness)
	{
		this.acousticness = acousticness;
	}

	/**
	 * Method 'getInstrumentalness()'
	 * 
	 * @return int
	 */
	public int getInstrumentalness()
	{
		return instrumentalness;
	}

	/**
	 * Method 'setInstrumentalness'
	 *
	 * @param instrumentalness
	 */
	public void setInstrumentalness(int instrumentalness)
	{
		this.instrumentalness = instrumentalness;
	}

	/**
	 * Method 'getLiveness()'
	 * 
	 * @return int
	 */
	public int getLiveness()
	{
		return liveness;
	}

	/**
	 * Method 'setLiveness'
	 *
	 * @param liveness
	 */
	public void setLiveness(int liveness)
	{
		this.liveness = liveness;
	}

	/**
	 * Method 'getValence()'
	 * 
	 * @return int
	 */
	public int getValence()
	{
		return valence;
	}

	/**
	 * Method 'setValence'
	 *
	 * @param valence
	 */
	public void setValence(int valence)
	{
		this.valence = valence;
	}

	/**
	 * Method 'getTempo()'
	 * 
	 * @return int
	 */
	public int getTempo()
	{
		return tempo;
	}

	/**
	 * Method 'setTempo'
	 *
	 * @param tempo
	 */
	public void setTempo(int tempo)
	{
		this.tempo = tempo;
	}

	/**
	 * Method 'getTimeSignature()'
	 * 
	 * @return int
	 */
	public int getTimeSignature()
	{
		return timeSignature;
	}

	/**
	 * Method 'setTimeSignature'
	 *
	 * @param timeSignature
	 */
	public void setTimeSignature(int timeSignature)
	{
		this.timeSignature = timeSignature;
	}

	@Override 
	public int hashCode()
	{
		return Objects.hash(trackId,
				danceability,
				energy,
				songKey,
				loudness,
				mode,
				speechiness,
				acousticness,
				instrumentalness,
				liveness,
				valence,
				tempo,
				timeSignature);
	}

	@Override 
	public boolean equals(Object obj)
	{
		if (this == obj) 
			return true; 
		if (obj == null) 
			return false; 
		if (getClass() != obj.getClass()) 
			return false; 
		Tracks other = (Tracks) obj; 
		return Objects.equals(trackId, other.trackId)
				&& danceability == other.danceability
				&& energy == other.energy
				&& songKey == other.songKey
				&& loudness == other.loudness
				&& mode == other.mode
				&& speechiness == other.speechiness
				&& acousticness == other.acousticness
				&& instrumentalness == other.instrumentalness
				&& liveness == other.liveness
				&& valence == other.valence
				&& tempo == other.tempo
				&& timeSignature == other.timeSignature;
	}

	@Override 
	public String toString()
	{
		return "Tracks [trackId=" + trackId + ","
				+ "danceability=" + danceability + ","
				+ "energy=" + energy + ","
				+ "songKey=" + songKey + ","
				+ "loudness=" + loudness + ","
				+ "mode=" + mode + ","
				+ "speechiness=" + speechiness + ","
				+ "acousticness=" + acousticness + ","
				+ "instrumentalness=" + instrumentalness + ","
				+ "liveness=" + liveness + ","
				+ "valence=" + valence + ","
				+ "tempo=" + tempo + ","
				+ "timeSignature=" + timeSignature + "]";
	}

//-CREATE_PK-
}
