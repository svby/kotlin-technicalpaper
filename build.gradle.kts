group = "com.github.stuhlmeier"
version = "0.0.1"

plugins {
    id("org.asciidoctor.jvm.base") version "2.3.0"
    id("org.asciidoctor.jvm.convert") version "2.3.0"
    id("org.asciidoctor.jvm.pdf") version "2.3.0"
}

repositories {
    mavenCentral()
}

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

tasks {
    asciidoctorPdf {
        baseDirFollowsSourceDir()
        setTheme("spengergasse")
    }
}
