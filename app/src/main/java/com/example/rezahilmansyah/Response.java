package com.example.rezahilmansyah;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class Response {

    /**
     * seed : 49c38d8dc834270d
     * results : 5
     * page : 1
     * version : 1.3
     */

    public InfoBean info;
    /**
     * gender : female
     * name : {"title":"Ms","first":"Gönül","last":"Dose"}
     * location : {"street":{"number":2649,"name":"Friedhofstraße"},"city":"Putbus","state":"Sachsen-Anhalt","country":"Germany","postcode":52113,"coordinates":{"latitude":"-42.1872","longitude":"148.7862"},"timezone":{"offset":"+1:00","description":"Brussels, Copenhagen, Madrid, Paris"}}
     * email : gonul.dose@example.com
     * dob : {"date":"1958-02-24T02:27:00.907Z","age":63}
     * phone : 0356-4624769
     * cell : 0170-3955620
     * id : {"name":"","value":null}
     * picture : {"large":"https://randomuser.me/api/portraits/women/23.jpg","medium":"https://randomuser.me/api/portraits/med/women/23.jpg","thumbnail":"https://randomuser.me/api/portraits/thumb/women/23.jpg"}
     * nat : DE
     */

    public List<ResultsBean> results;

    public static Response objectFromData(String str) {

        return new Gson().fromJson(str, Response.class);
    }

    public static Response objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), Response.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static class InfoBean {
        public String seed;
        public int results;
        public int page;
        public String version;

        public static InfoBean objectFromData(String str) {

            return new Gson().fromJson(str, InfoBean.class);
        }

        public static InfoBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), InfoBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }
    }

    public static class ResultsBean {
        public String gender;
        /**
         * title : Ms
         * first : Gönül
         * last : Dose
         */

        public NameBean name;
        /**
         * street : {"number":2649,"name":"Friedhofstraße"}
         * city : Putbus
         * state : Sachsen-Anhalt
         * country : Germany
         * postcode : 52113
         * coordinates : {"latitude":"-42.1872","longitude":"148.7862"}
         * timezone : {"offset":"+1:00","description":"Brussels, Copenhagen, Madrid, Paris"}
         */

        public LocationBean location;
        public String email;
        /**
         * date : 1958-02-24T02:27:00.907Z
         * age : 63
         */

        public DobBean dob;
        public String phone;
        public String cell;
        /**
         * name :
         * value : null
         */

        public IdBean id;
        /**
         * large : https://randomuser.me/api/portraits/women/23.jpg
         * medium : https://randomuser.me/api/portraits/med/women/23.jpg
         * thumbnail : https://randomuser.me/api/portraits/thumb/women/23.jpg
         */

        public PictureBean picture;
        public String nat;

        public static ResultsBean objectFromData(String str) {

            return new Gson().fromJson(str, ResultsBean.class);
        }

        public static ResultsBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), ResultsBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static class NameBean {
            public String title;
            public String first;
            public String last;

            public static NameBean objectFromData(String str) {

                return new Gson().fromJson(str, NameBean.class);
            }

            public static NameBean objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), NameBean.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }
        }

        public static class LocationBean {
            /**
             * number : 2649
             * name : Friedhofstraße
             */

            public StreetBean street;
            public String city;
            public String state;
            public String country;
            public int postcode;
            /**
             * latitude : -42.1872
             * longitude : 148.7862
             */

            public CoordinatesBean coordinates;
            /**
             * offset : +1:00
             * description : Brussels, Copenhagen, Madrid, Paris
             */

            public TimezoneBean timezone;

            public static LocationBean objectFromData(String str) {

                return new Gson().fromJson(str, LocationBean.class);
            }

            public static LocationBean objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), LocationBean.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }

            public static class StreetBean {
                public int number;
                public String name;

                public static StreetBean objectFromData(String str) {

                    return new Gson().fromJson(str, StreetBean.class);
                }

                public static StreetBean objectFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);

                        return new Gson().fromJson(jsonObject.getString(str), StreetBean.class);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return null;
                }
            }

            public static class CoordinatesBean {
                public String latitude;
                public String longitude;

                public static CoordinatesBean objectFromData(String str) {

                    return new Gson().fromJson(str, CoordinatesBean.class);
                }

                public static CoordinatesBean objectFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);

                        return new Gson().fromJson(jsonObject.getString(str), CoordinatesBean.class);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return null;
                }
            }

            public static class TimezoneBean {
                public String offset;
                public String description;

                public static TimezoneBean objectFromData(String str) {

                    return new Gson().fromJson(str, TimezoneBean.class);
                }

                public static TimezoneBean objectFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);

                        return new Gson().fromJson(jsonObject.getString(str), TimezoneBean.class);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return null;
                }
            }
        }

        public static class DobBean {
            public String date;
            public int age;

            public static DobBean objectFromData(String str) {

                return new Gson().fromJson(str, DobBean.class);
            }

            public static DobBean objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), DobBean.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }
        }

        public static class IdBean {
            public String name;
            public Object value;

            public static IdBean objectFromData(String str) {

                return new Gson().fromJson(str, IdBean.class);
            }

            public static IdBean objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), IdBean.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }
        }

        public static class PictureBean {
            public String large;
            public String medium;
            public String thumbnail;

            public static PictureBean objectFromData(String str) {

                return new Gson().fromJson(str, PictureBean.class);
            }

            public static PictureBean objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), PictureBean.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }
        }
    }
}
