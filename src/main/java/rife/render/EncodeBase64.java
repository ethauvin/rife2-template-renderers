/*
 *  Copyright 2023-2024 the original author or authors.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       https://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package rife.render;

import rife.template.Template;
import rife.template.ValueRenderer;
import rife.tools.StringUtils;

import java.nio.charset.StandardCharsets;

/**
 * <p>Encodes a template value to Base64.</p>
 *
 * <p>Usage:</p>
 *
 * <pre>
 *   &lt;!--v render:rife.render.EncodeBase64:valueId/--&gt;
 *   {{v render:rife.render.EncodeBase64:valueId/}}
 * </pre>
 *
 * @author <a href="https://erik.thauvin.net/">Erik C. Thauvin</a>
 * @see <a href="https://github.com/rife2/rife2-template-renderers/wiki/rife.render.EncodeBase64">rife.render.EncodeBase64</a>
 * @see StringUtils#encodeBase64(byte[])
 * @since 1.0
 */
public class EncodeBase64 implements ValueRenderer {
    /**
     * Returns the template value encoded to Base64.
     *
     * @param template       the template that contains the value
     * @param valueId        the id of the value
     * @param differentiator the differentiator to use
     * @return the Base64-encoded value
     */
    @Override
    public String render(Template template, String valueId, String differentiator) {
        var properties = RenderUtils.parsePropertiesString(template.getDefaultValue(valueId));
        return RenderUtils.encode(
                StringUtils.encodeBase64(template.getValueOrAttribute(differentiator).getBytes(StandardCharsets.UTF_8)),
                properties);
    }
}
