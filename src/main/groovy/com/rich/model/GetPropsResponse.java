//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-558 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.01.13 at 10:35:07 AM CST 
//


package com.rich.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="all" type="{http://spring.io/guides/gs-producing-web-service}getPokemonResponse"/>
 *         &lt;element name="abilities" type="{http://spring.io/guides/gs-producing-web-service}getPokemonAbilitiesResponse"/>
 *         &lt;element name="id" type="{http://spring.io/guides/gs-producing-web-service}getPokemonIdResponse"/>
 *         &lt;element name="baseExperience" type="{http://spring.io/guides/gs-producing-web-service}getPokemonBaseExperienceResponse"/>
 *         &lt;element name="heldItems" type="{http://spring.io/guides/gs-producing-web-service}getPokemonHeldItemsResponse"/>
 *         &lt;element name="locationArea" type="{http://spring.io/guides/gs-producing-web-service}getPokemonLocationAreaEncountersResponse"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "all",
    "abilities",
    "id",
    "baseExperience",
    "heldItems",
    "locationArea"
})
@XmlRootElement(name = "getPropsResponse")
public class GetPropsResponse {

    @XmlElement(required = true)
    protected GetPokemonResponse all;
    @XmlElement(required = true)
    protected GetPokemonAbilitiesResponse abilities;
    @XmlElement(required = true)
    protected GetPokemonIdResponse id;
    @XmlElement(required = true)
    protected GetPokemonBaseExperienceResponse baseExperience;
    @XmlElement(required = true)
    protected GetPokemonHeldItemsResponse heldItems;
    @XmlElement(required = true)
    protected GetPokemonLocationAreaEncountersResponse locationArea;

    /**
     * Gets the value of the all property.
     * 
     * @return
     *     possible object is
     *     {@link GetPokemonResponse }
     *     
     */
    public GetPokemonResponse getAll() {
        return all;
    }

    /**
     * Sets the value of the all property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetPokemonResponse }
     *     
     */
    public void setAll(GetPokemonResponse value) {
        this.all = value;
    }

    /**
     * Gets the value of the abilities property.
     * 
     * @return
     *     possible object is
     *     {@link GetPokemonAbilitiesResponse }
     *     
     */
    public GetPokemonAbilitiesResponse getAbilities() {
        return abilities;
    }

    /**
     * Sets the value of the abilities property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetPokemonAbilitiesResponse }
     *     
     */
    public void setAbilities(GetPokemonAbilitiesResponse value) {
        this.abilities = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link GetPokemonIdResponse }
     *     
     */
    public GetPokemonIdResponse getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetPokemonIdResponse }
     *     
     */
    public void setId(GetPokemonIdResponse value) {
        this.id = value;
    }

    /**
     * Gets the value of the baseExperience property.
     * 
     * @return
     *     possible object is
     *     {@link GetPokemonBaseExperienceResponse }
     *     
     */
    public GetPokemonBaseExperienceResponse getBaseExperience() {
        return baseExperience;
    }

    /**
     * Sets the value of the baseExperience property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetPokemonBaseExperienceResponse }
     *     
     */
    public void setBaseExperience(GetPokemonBaseExperienceResponse value) {
        this.baseExperience = value;
    }

    /**
     * Gets the value of the heldItems property.
     * 
     * @return
     *     possible object is
     *     {@link GetPokemonHeldItemsResponse }
     *     
     */
    public GetPokemonHeldItemsResponse getHeldItems() {
        return heldItems;
    }

    /**
     * Sets the value of the heldItems property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetPokemonHeldItemsResponse }
     *     
     */
    public void setHeldItems(GetPokemonHeldItemsResponse value) {
        this.heldItems = value;
    }

    /**
     * Gets the value of the locationArea property.
     * 
     * @return
     *     possible object is
     *     {@link GetPokemonLocationAreaEncountersResponse }
     *     
     */
    public GetPokemonLocationAreaEncountersResponse getLocationArea() {
        return locationArea;
    }

    /**
     * Sets the value of the locationArea property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetPokemonLocationAreaEncountersResponse }
     *     
     */
    public void setLocationArea(GetPokemonLocationAreaEncountersResponse value) {
        this.locationArea = value;
    }

}