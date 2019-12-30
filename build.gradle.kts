group = "com.github.stuhlmeier"
version = "0.0.1"

plugins {
    id("org.asciidoctor.jvm.base") version "3.0.0-alpha.4"
    id("org.asciidoctor.jvm.convert") version "3.0.0-alpha.4"
    id("org.asciidoctor.jvm.pdf") version "3.0.0-alpha.4"
}

repositories {
    mavenCentral()
}

asciidoctorj {
    setOptions(mapOf("doctype" to "book"))
    setAttributes(mapOf(
            "source-highlighter" to "rouge",
            "toc" to "left",
            "toclevels" to 5,
            "idprefix" to "",
            "idseparator" to "-",
            "experimental" to ""
    ))

    modules {
        diagram.version("2.0.0")
    }
}

pdfThemes {
    local("spengergasse") {
        themeDir = file("src/docs/themes")
        themeName = "spengergasse"
    }
}

tasks {
    asciidoctorPdf {
        baseDirFollowsSourceDir()
        setTheme("spengergasse")
    }
}
