package com.example;

import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.domain.JavaField;
import com.tngtech.archunit.core.domain.JavaMethod;
import com.tngtech.archunit.core.domain.JavaModifier;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ImmutabilityTest {

    private static final String DTO_PACKAGE = "com.example.dto";

    @Test
    void all_fields_should_be_final() {
        JavaClasses classes = new ClassFileImporter().importPackages(DTO_PACKAGE);

        for (JavaClass clazz : classes) {
            for (JavaField field : clazz.getFields()) {
                assertThat(field.getModifiers().contains(JavaModifier.FINAL))
                        .as("Field '%s' in class '%s' should be final", field.getName(), clazz.getName())
                        .isTrue();
            }
        }
    }

    @Test
    void all_classes_should_be_final() {
        ArchRule rule = ArchRuleDefinition.classes()
                .that().resideInAPackage(DTO_PACKAGE)
                .should().haveModifier(JavaModifier.FINAL);

        rule.check(new ClassFileImporter().importPackages(DTO_PACKAGE));
    }

    @Test
    void dto_classes_should_not_have_public_setters() {
        JavaClasses classes = new ClassFileImporter().importPackages(DTO_PACKAGE);

        for (JavaClass clazz : classes) {
            for (JavaMethod method : clazz.getMethods()) {
                if (method.getName().startsWith("set")) {
                    assertThat(method.getModifiers().contains(JavaModifier.PUBLIC))
                            .as("DTO class '%s' should not have public setters, but found: %s", clazz.getName(), method.getName())
                            .isFalse();
                }
            }
        }
    }
}
