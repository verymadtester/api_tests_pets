package helpers;

import lombok.NoArgsConstructor;

public class Endpoints {

    @NoArgsConstructor
    public static class Commons {

        public static final String PET = "/pet";
        public static final String STORE = "/store";
        public static final String USER = "/user";

    }

    @NoArgsConstructor
    public static class Pets {

        public static final String FIND_BY_STATUS = "/findByStatus";
        public static final String FIND_BY_TAGS = "/findByTags";
        public static final String UPLOAD_IMAGE = "/uploadImage";

    }
}
