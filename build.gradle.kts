buildscript {
    repositories {
        mavenCentral()
    }

    dependencies {
        classpath("org.asciidoctor:asciidoctorj-pdf:1.5.0-beta.7")
    }
}

repositories {
    mavenCentral()
}

group = "com.github.stuhlmeier"
version = "0.0.1"

plugins {
    id("org.asciidoctor.jvm.base") version "2.3.0"
    id("org.asciidoctor.jvm.convert") version "2.3.0"
    id("org.asciidoctor.jvm.pdf") version "2.3.0"
}

tasks {
    asciidoctorj {
        setOptions(mapOf("doctype" to "article"))
        setAttributes(mapOf(
                "source-highlighter" to "rouge",
                "toc" to "left",
                "idprefix" to "",
                "idseparator" to "-"
        ))

        modules {
            diagram.version("1.5.18")
        }
    }

    pdfThemes {
        local("spengergasse") {
            styleDir = file("src/docs/themes")
            styleName = "spengergasse"
        }
    }

    asciidoctorPdf {
        setTheme("spengergasse")
    }
}
