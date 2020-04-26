package edu.cis.cisgsearch.Model.GoogleSearch;

public class TARestProfile
{
    private String name;
    private String city;
    private String custyle;
    private String ranking;
    private String rating;
    private String pRange;
    private String NOR;
    private String reviews;
    private String url;
    private String id;

    public TARestProfile(String name, String city, String custyle, String ranking, String rating,
                         String pRange, String NOR, String reviews, String url, String id)
    {
        this.name = name;
        this.city = city;
        this.custyle = custyle;
        this.ranking = ranking;
        this.rating = rating;
        this.pRange = pRange;
        this.NOR = NOR;
        this.reviews = reviews;
        this.url = url;
        this.id = id;
    }

    public TARestProfile()
    {
        this.name = "Information could not be found";
        this.city = "Information could not be found";
        this.custyle = "Information could not be found";
        this.ranking = "Information could not be found";
        this.rating = "Information could not be found";
        this.pRange = "Information could not be found";
        this.NOR = "Information could not be found";
        this.reviews = "Information could not be found";
        this.url = "Information could not be found";
        this.id = "Information could not be found";
    }


    public String getName()
    {
        return name;
    }

    public String getCity()
    {
        return city;
    }

    public String getCustyle()
    {
        return custyle;
    }

    public String getRanking()
    {
        return ranking;
    }

    public String getRating()
    {
        return rating;
    }

    public String getpRange()
    {
        return pRange;
    }

    public String getNOR()
    {
        return NOR;
    }

    public String getReviews()
    {
        return reviews;
    }

    public String getUrl()
    {
        return url;
    }

    public String getId()
    {
        return id;
    }
}
