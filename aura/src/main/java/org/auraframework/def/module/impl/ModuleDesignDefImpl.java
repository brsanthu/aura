/*
 * Copyright (C) 2013 salesforce.com, inc.
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
package org.auraframework.def.module.impl;

import org.auraframework.def.module.ModuleDesignDef;
import org.auraframework.def.module.TargetConfigs;
import org.auraframework.throwable.quickfix.InvalidDefinitionException;
import org.springframework.util.StringUtils;

/**
 * ModuleDesignDef holds all the design configuration of a
 * LWC component specified in -meta.xml 
 */
public class ModuleDesignDefImpl implements ModuleDesignDef {
        private static final long serialVersionUID = -9187646383220697438L;
        private String label;
    private String description;
    private TargetConfigs targetConfigs;

    ModuleDesignDefImpl(ModuleDesignDefImpl.Builder builder) {
        label = builder.getLabel();
        description = builder.getDescription();
        targetConfigs = builder.getTargetConfigs();
    }

    @Override
    public TargetConfigs configs() {
       return targetConfigs;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public static final class Builder {
        private String label;
        private String description;
        private TargetConfigs targetConfigs;

        public Builder setLabel(String label) throws InvalidDefinitionException {
            if (this.label != null) {
                throw new InvalidDefinitionException("The <masterLabel> tag is specified more than once.", null);
            }
            if (StringUtils.hasText(label)) {
                this.label = label;
            } else {
                throw new InvalidDefinitionException("The label is empty", null);
            }
            return this;
        }

        public Builder setDescription(String description) throws InvalidDefinitionException {
            if (this.description != null) {
                throw new InvalidDefinitionException("The <description> tag is specified more than once.", null);
            }
            if (StringUtils.hasText(description)) {
                this.description = description;
            } else {
                throw new InvalidDefinitionException("The description is empty", null);
            }
            return this;
        }
        
        public Builder setTargetConfigs(TargetConfigs targetConfigs) {
            this.targetConfigs = targetConfigs;
            return this;
        }

        public TargetConfigs getTargetConfigs() {
            return this.targetConfigs;
        }
        
        String getLabel() {
            return label;
        }
        
        String getDescription() {
            return description;
        }

        public ModuleDesignDefImpl build() {
            return new ModuleDesignDefImpl(this);
        }
    }
}