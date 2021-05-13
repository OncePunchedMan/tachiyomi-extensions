package eu.kanade.tachiyomi.extension.en.manhwahot

import eu.kanade.tachiyomi.annotations.Nsfw
import eu.kanade.tachiyomi.multisrc.fmreader.FMReader
import eu.kanade.tachiyomi.network.GET
import eu.kanade.tachiyomi.source.model.Page
import okhttp3.Request

@Nsfw
class ManhwaHot : FMReader("ManhwaHot", "https://manhwahot.com", "en") {
    private val noReferer = headersBuilder().removeAll("Referer").build()
    override fun imageRequest(page: Page): Request = GET(page.imageUrl!!, if (page.imageUrl!!.contains("toonily")) noReferer else headers)
}
