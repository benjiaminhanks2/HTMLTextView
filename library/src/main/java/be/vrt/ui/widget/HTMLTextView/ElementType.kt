package be.vrt.ui.widget.HTMLTextView

enum class ElementType(val shouldBeRenderedNative: Boolean = false) {
    DIV(true),
    SPAN(),
    P(true),
    IMG(true),
    A(true),
    B(true),
    I(true),

    UL(),
    LI(),

    HEADER(),
    ARTICLE(),
    SECTION(),

    H1(true),
    H2(true),
    H3(true),
    H4(true),
    H5(true),
    H6(true),
}