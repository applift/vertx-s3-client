/**
 * Copyright (C) 2016 Etaia AS (oss@hubrick.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hubrick.vertx.s3.client;

import io.vertx.ext.unit.TestContext;
import org.junit.Test;

import java.io.IOException;
import java.util.UUID;

/**
 * @author marcus
 * @since 1.0.0
 */
public class S3ClientWithoutCredentialsTest extends AbstractS3ClientTest {

    @Override
    protected void augmentClientOptions(final S3ClientOptions clientOptions) {
    }

    @Test
    public void testGetObject(TestContext testContext) throws IOException {
        mockGetObject();

        verifyGetObject(testContext);
    }


    @Test
    public void testHeadObject(TestContext testContext) throws IOException {
        mockHeadObject();

        verifyHeadObject(testContext);
    }

    @Test
    public void testPutObject(TestContext testContext) throws IOException {
        mockPutObject();

        verifyPutObject(testContext);
    }

    @Test
    public void testInitMultipartUpload(TestContext testContext) throws IOException {
        mockInitMultipartUpload(UUID.randomUUID().toString());

        verifyInitMultipartUpload(testContext);
    }

    @Test
    public void testContinueMultipartUpload(TestContext testContext) throws IOException {
        mockContinueMultipartUpload(1, "someid");

        verifyContinueMultipartUpload(testContext, 1, "someid");
    }

    @Test
    public void testCompleteMultipartUpload(TestContext testContext) throws IOException {
        mockCompleteMultipartUpload("someid");

        verifyCompleteMultipartUpload(testContext, "someid");
    }

    @Test
    public void testAbortMultipartUpload(TestContext testContext) throws IOException {
        mockAbortMultipartUpload("someid");

        verifyAbortMultipartUpload(testContext, "someid");
    }

    @Test
    public void testDeleteObject(TestContext testContext) throws IOException {
        mockDeleteObject();

        verifyDeleteObject(testContext);
    }

    @Test
    public void testCopyObject(TestContext testContext) throws IOException {
        mockCopyObject();

        verifyCopyObject(testContext);

    }
}
