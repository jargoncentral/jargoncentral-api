package com.jargoncentral.common.enums;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public enum Role {
    Contributor,
    Author
}
