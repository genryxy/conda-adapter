/*
 * The MIT License (MIT) Copyright (c) 2020-2021 artipie.com
 * https://github.com/artipie/conda-adapter/LICENSE
 */
package com.artipie.conda.http;

import com.artipie.http.Response;
import com.artipie.http.Slice;
import com.artipie.http.rs.common.RsJson;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import javax.json.Json;
import org.reactivestreams.Publisher;

/**
 * Slice for token authorization.
 * @since 0.4
 * @todo #32:30min Implement this slice properly to return authorization token for user. It serves
 *  on `POST /authentications`. For more details check swagger api page:
 *  https://api.anaconda.org/docs#!/authentication/post_authentications
 */
final class AuthTokenSlice implements Slice {

    @Override
    public Response response(final String line, final Iterable<Map.Entry<String, String>> headers,
        final Publisher<ByteBuffer> body) {
        return new RsJson(
            () -> Json.createObjectBuilder().add("token", "ol-4ee312d8-9fe2-44d2-bea9-053325e1ffd5")
                .build(),
            StandardCharsets.UTF_8
        );
    }
}
