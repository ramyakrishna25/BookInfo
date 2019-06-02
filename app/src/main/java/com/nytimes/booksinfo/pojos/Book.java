

package com.nytimes.booksinfo.pojos;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Book {


    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("copyright")
    @Expose
    private String copyright;
    @SerializedName("num_results")
    @Expose
    private Integer numResults;
    @SerializedName("last_modified")
    @Expose
    private String lastModified;
    @SerializedName("results")
    @Expose
    private Results results;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public Integer getNumResults() {
        return numResults;
    }

    public void setNumResults(Integer numResults) {
        this.numResults = numResults;
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    public Results getResults() {
        return results;
    }

    public void setResults(Results results) {
        this.results = results;
    }


    public static  class BuyLink implements Parcelable {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("url")
        @Expose
        private String url;

        protected BuyLink(Parcel in) {
            name = in.readString();
            url = in.readString();
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(name);
            dest.writeString(url);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public static final Creator<BuyLink> CREATOR = new Creator<BuyLink>() {
            @Override
            public BuyLink createFromParcel(Parcel in) {
                return new BuyLink(in);
            }

            @Override
            public BuyLink[] newArray(int size) {
                return new BuyLink[size];
            }
        };

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

    }


    public static class Books implements Parcelable
    {

        @SerializedName("rank")
        @Expose
        private Integer rank;
        @SerializedName("rank_last_week")
        @Expose
        private Integer rankLastWeek;
        @SerializedName("weeks_on_list")
        @Expose
        private Integer weeksOnList;
        @SerializedName("asterisk")
        @Expose
        private Integer asterisk;
        @SerializedName("dagger")
        @Expose
        private Integer dagger;
        @SerializedName("primary_isbn10")
        @Expose
        private String primaryIsbn10;
        @SerializedName("primary_isbn13")
        @Expose
        private String primaryIsbn13;
        @SerializedName("publisher")
        @Expose
        private String publisher;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("price")
        @Expose
        private Integer price;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("author")
        @Expose
        private String author;
        @SerializedName("contributor")
        @Expose
        private String contributor;
        @SerializedName("contributor_note")
        @Expose
        private String contributorNote;
        @SerializedName("book_image")
        @Expose
        private String bookImage;
        @SerializedName("book_image_width")
        @Expose
        private Integer bookImageWidth;
        @SerializedName("book_image_height")
        @Expose
        private Integer bookImageHeight;
        @SerializedName("amazon_product_url")
        @Expose
        private String amazonProductUrl;
        @SerializedName("age_group")
        @Expose
        private String ageGroup;
        @SerializedName("book_review_link")
        @Expose
        private String bookReviewLink;
        @SerializedName("first_chapter_link")
        @Expose
        private String firstChapterLink;
        @SerializedName("sunday_review_link")
        @Expose
        private String sundayReviewLink;
        @SerializedName("article_chapter_link")
        @Expose
        private String articleChapterLink;
        @SerializedName("isbns")
        @Expose
        private List<Isbn> isbns = null;
        @SerializedName("buy_links")
        @Expose
        private List<BuyLink> buyLinks = null;

        public Books(Parcel in) {
            if (in.readByte() == 0) {
                rank = null;
            } else {
                rank = in.readInt();
            }
            if (in.readByte() == 0) {
                rankLastWeek = null;
            } else {
                rankLastWeek = in.readInt();
            }
            if (in.readByte() == 0) {
                weeksOnList = null;
            } else {
                weeksOnList = in.readInt();
            }
            if (in.readByte() == 0) {
                asterisk = null;
            } else {
                asterisk = in.readInt();
            }
            if (in.readByte() == 0) {
                dagger = null;
            } else {
                dagger = in.readInt();
            }
            primaryIsbn10 = in.readString();
            primaryIsbn13 = in.readString();
            publisher = in.readString();
            description = in.readString();
            if (in.readByte() == 0) {
                price = null;
            } else {
                price = in.readInt();
            }
            title = in.readString();
            author = in.readString();
            contributor = in.readString();
            contributorNote = in.readString();
            bookImage = in.readString();
            if (in.readByte() == 0) {
                bookImageWidth = null;
            } else {
                bookImageWidth = in.readInt();
            }
            if (in.readByte() == 0) {
                bookImageHeight = null;
            } else {
                bookImageHeight = in.readInt();
            }
            amazonProductUrl = in.readString();
            ageGroup = in.readString();
            bookReviewLink = in.readString();
            firstChapterLink = in.readString();
            sundayReviewLink = in.readString();
            articleChapterLink = in.readString();
        }

        public static final Creator<Books> CREATOR = new Creator<Books>() {
            @Override
            public Books createFromParcel(Parcel in) {
                return new Books(in);
            }

            @Override
            public Books[] newArray(int size) {
                return new Books[size];
            }
        };

        public Books() {
        }

        public Integer getRank() {
            return rank;
        }

        public void setRank(Integer rank) {
            this.rank = rank;
        }

        public Integer getRankLastWeek() {
            return rankLastWeek;
        }

        public void setRankLastWeek(Integer rankLastWeek) {
            this.rankLastWeek = rankLastWeek;
        }

        public Integer getWeeksOnList() {
            return weeksOnList;
        }

        public void setWeeksOnList(Integer weeksOnList) {
            this.weeksOnList = weeksOnList;
        }

        public Integer getAsterisk() {
            return asterisk;
        }

        public void setAsterisk(Integer asterisk) {
            this.asterisk = asterisk;
        }

        public Integer getDagger() {
            return dagger;
        }

        public void setDagger(Integer dagger) {
            this.dagger = dagger;
        }

        public String getPrimaryIsbn10() {
            return primaryIsbn10;
        }

        public void setPrimaryIsbn10(String primaryIsbn10) {
            this.primaryIsbn10 = primaryIsbn10;
        }

        public String getPrimaryIsbn13() {
            return primaryIsbn13;
        }

        public void setPrimaryIsbn13(String primaryIsbn13) {
            this.primaryIsbn13 = primaryIsbn13;
        }

        public String getPublisher() {
            return publisher;
        }

        public void setPublisher(String publisher) {
            this.publisher = publisher;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Integer getPrice() {
            return price;
        }

        public void setPrice(Integer price) {
            this.price = price;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getContributor() {
            return contributor;
        }

        public void setContributor(String contributor) {
            this.contributor = contributor;
        }

        public String getContributorNote() {
            return contributorNote;
        }

        public void setContributorNote(String contributorNote) {
            this.contributorNote = contributorNote;
        }

        public String getBookImage() {
            return bookImage;
        }

        public void setBookImage(String bookImage) {
            this.bookImage = bookImage;
        }

        public Integer getBookImageWidth() {
            return bookImageWidth;
        }

        public void setBookImageWidth(Integer bookImageWidth) {
            this.bookImageWidth = bookImageWidth;
        }

        public Integer getBookImageHeight() {
            return bookImageHeight;
        }

        public void setBookImageHeight(Integer bookImageHeight) {
            this.bookImageHeight = bookImageHeight;
        }

        public String getAmazonProductUrl() {
            return amazonProductUrl;
        }

        public void setAmazonProductUrl(String amazonProductUrl) {
            this.amazonProductUrl = amazonProductUrl;
        }

        public String getAgeGroup() {
            return ageGroup;
        }

        public void setAgeGroup(String ageGroup) {
            this.ageGroup = ageGroup;
        }

        public String getBookReviewLink() {
            return bookReviewLink;
        }

        public void setBookReviewLink(String bookReviewLink) {
            this.bookReviewLink = bookReviewLink;
        }

        public String getFirstChapterLink() {
            return firstChapterLink;
        }

        public void setFirstChapterLink(String firstChapterLink) {
            this.firstChapterLink = firstChapterLink;
        }

        public String getSundayReviewLink() {
            return sundayReviewLink;
        }

        public void setSundayReviewLink(String sundayReviewLink) {
            this.sundayReviewLink = sundayReviewLink;
        }

        public String getArticleChapterLink() {
            return articleChapterLink;
        }

        public void setArticleChapterLink(String articleChapterLink) {
            this.articleChapterLink = articleChapterLink;
        }

        public List<Isbn> getIsbns() {
            return isbns;
        }

        public void setIsbns(List<Isbn> isbns) {
            this.isbns = isbns;
        }

        public List<BuyLink> getBuyLinks() {
            return buyLinks;
        }

        public void setBuyLinks(List<BuyLink> buyLinks) {
            this.buyLinks = buyLinks;
        }


        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            if (rank == null) {
                dest.writeByte((byte) 0);
            } else {
                dest.writeByte((byte) 1);
                dest.writeInt(rank);
            }
            if (rankLastWeek == null) {
                dest.writeByte((byte) 0);
            } else {
                dest.writeByte((byte) 1);
                dest.writeInt(rankLastWeek);
            }
            if (weeksOnList == null) {
                dest.writeByte((byte) 0);
            } else {
                dest.writeByte((byte) 1);
                dest.writeInt(weeksOnList);
            }
            if (asterisk == null) {
                dest.writeByte((byte) 0);
            } else {
                dest.writeByte((byte) 1);
                dest.writeInt(asterisk);
            }
            if (dagger == null) {
                dest.writeByte((byte) 0);
            } else {
                dest.writeByte((byte) 1);
                dest.writeInt(dagger);
            }
            dest.writeString(primaryIsbn10);
            dest.writeString(primaryIsbn13);
            dest.writeString(publisher);
            dest.writeString(description);
            if (price == null) {
                dest.writeByte((byte) 0);
            } else {
                dest.writeByte((byte) 1);
                dest.writeInt(price);
            }
            dest.writeString(title);
            dest.writeString(author);
            dest.writeString(contributor);
            dest.writeString(contributorNote);
            dest.writeString(bookImage);
            if (bookImageWidth == null) {
                dest.writeByte((byte) 0);
            } else {
                dest.writeByte((byte) 1);
                dest.writeInt(bookImageWidth);
            }
            if (bookImageHeight == null) {
                dest.writeByte((byte) 0);
            } else {
                dest.writeByte((byte) 1);
                dest.writeInt(bookImageHeight);
            }
            dest.writeString(amazonProductUrl);
            dest.writeString(ageGroup);
            dest.writeString(bookReviewLink);
            dest.writeString(firstChapterLink);
            dest.writeString(sundayReviewLink);
            dest.writeString(articleChapterLink);
        }
    }

    public class Isbn {

        @SerializedName("isbn10")
        @Expose
        private String isbn10;
        @SerializedName("isbn13")
        @Expose
        private String isbn13;

        public String getIsbn10() {
            return isbn10;
        }

        public void setIsbn10(String isbn10) {
            this.isbn10 = isbn10;
        }

        public String getIsbn13() {
            return isbn13;
        }

        public void setIsbn13(String isbn13) {
            this.isbn13 = isbn13;
        }

    }


    public class Results {

        @SerializedName("list_name")
        @Expose
        private String listName;
        @SerializedName("list_name_encoded")
        @Expose
        private String listNameEncoded;
        @SerializedName("bestsellers_date")
        @Expose
        private String bestsellersDate;
        @SerializedName("published_date")
        @Expose
        private String publishedDate;
        @SerializedName("published_date_description")
        @Expose
        private String publishedDateDescription;
        @SerializedName("next_published_date")
        @Expose
        private String nextPublishedDate;
        @SerializedName("previous_published_date")
        @Expose
        private String previousPublishedDate;
        @SerializedName("display_name")
        @Expose
        private String displayName;
        @SerializedName("normal_list_ends_at")
        @Expose
        private Integer normalListEndsAt;
        @SerializedName("updated")
        @Expose
        private String updated;
        @SerializedName("books")
        @Expose
        private List<Books> books = null;
        @SerializedName("corrections")
        @Expose
        private List<Object> corrections = null;

        public String getListName() {
            return listName;
        }

        public void setListName(String listName) {
            this.listName = listName;
        }

        public String getListNameEncoded() {
            return listNameEncoded;
        }

        public void setListNameEncoded(String listNameEncoded) {
            this.listNameEncoded = listNameEncoded;
        }

        public String getBestsellersDate() {
            return bestsellersDate;
        }

        public void setBestsellersDate(String bestsellersDate) {
            this.bestsellersDate = bestsellersDate;
        }

        public String getPublishedDate() {
            return publishedDate;
        }

        public void setPublishedDate(String publishedDate) {
            this.publishedDate = publishedDate;
        }

        public String getPublishedDateDescription() {
            return publishedDateDescription;
        }

        public void setPublishedDateDescription(String publishedDateDescription) {
            this.publishedDateDescription = publishedDateDescription;
        }

        public String getNextPublishedDate() {
            return nextPublishedDate;
        }

        public void setNextPublishedDate(String nextPublishedDate) {
            this.nextPublishedDate = nextPublishedDate;
        }

        public String getPreviousPublishedDate() {
            return previousPublishedDate;
        }

        public void setPreviousPublishedDate(String previousPublishedDate) {
            this.previousPublishedDate = previousPublishedDate;
        }

        public String getDisplayName() {
            return displayName;
        }

        public void setDisplayName(String displayName) {
            this.displayName = displayName;
        }

        public Integer getNormalListEndsAt() {
            return normalListEndsAt;
        }

        public void setNormalListEndsAt(Integer normalListEndsAt) {
            this.normalListEndsAt = normalListEndsAt;
        }

        public String getUpdated() {
            return updated;
        }

        public void setUpdated(String updated) {
            this.updated = updated;
        }

        public List<Books> getBooks() {
            return books;
        }

        public void setBooks(List<Books> books) {
            this.books = books;
        }

        public List<Object> getCorrections() {
            return corrections;
        }

        public void setCorrections(List<Object> corrections) {
            this.corrections = corrections;
        }
    }
}