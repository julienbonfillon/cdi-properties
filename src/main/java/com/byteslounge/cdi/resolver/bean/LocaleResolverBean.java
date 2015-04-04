/*
 * Copyright 2015 byteslounge.com (Gonçalo Marques).
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.byteslounge.cdi.resolver.bean;

import java.util.Arrays;
import java.util.Locale;

import javax.enterprise.inject.spi.AnnotatedMethod;

import com.byteslounge.cdi.annotation.LocaleResolver;
import com.byteslounge.cdi.resolver.DefaultLocaleResolverMethod;
import com.byteslounge.cdi.resolver.verifier.DependentResolverMethodParametersVerifier;
import com.byteslounge.cdi.resolver.verifier.LocaleResolverMethodParametersVerifier;
import com.byteslounge.cdi.utils.ValidationUtils;

/**
 * Represents the Locale resolver bean which will be used to 
 * resolve the current {@link java.util.Locale} during property resolution 
 * 
 * @author Gonçalo Marques
 * @since 1.1.0
 */
public class LocaleResolverBean extends AbstractResolverBean<Locale> {

    public LocaleResolverBean() {
        super(LocaleResolver.class, "locale", DefaultLocaleResolverMethod.class);
    }

    /**
     * @see {@link com.byteslounge.cdi.resolver.bean.AbstractResolverBean#validate(AnnotatedMethod)}
     */
    @Override
    void validate(AnnotatedMethod<?> resolverMethod) {
        ValidationUtils.validateResolverMethod(Arrays.asList(
                new LocaleResolverMethodParametersVerifier(resolverMethod),
                new DependentResolverMethodParametersVerifier(resolverMethod)));
    }

}