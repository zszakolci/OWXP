// This file was automatically generated from RecommendedPages.soy.
// Please don't edit this file by hand.

/**
 * @fileoverview Templates in namespace RecommendedPages.
 * @public
 */

if (typeof RecommendedPages == 'undefined') { var RecommendedPages = {}; }


RecommendedPages.render = function(opt_data, opt_ignored) {
  goog.asserts.assert(opt_data.name == null || (opt_data.name instanceof goog.soy.data.SanitizedContent) || goog.isString(opt_data.name), "expected param 'name' of type null|string|undefined.");
  var name = /** @type {null|string|undefined} */ (opt_data.name);
  goog.asserts.assert(opt_data.recommendedPages == null || opt_data.recommendedPages != null, "expected param 'recommendedPages' of type (?).");
  var recommendedPages = /** @type {(?)} */ (opt_data.recommendedPages);
  var output = '<section id="' + soy.$$escapeHtmlAttribute(opt_data.id) + '"><h4 class="text-default">' + soy.$$escapeHtml(name) + '</h4><div class="row"><ul class="list-group">';
  if (recommendedPages) {
    var pageList12 = recommendedPages;
    var pageListLen12 = pageList12.length;
    for (var pageIndex12 = 0; pageIndex12 < pageListLen12; pageIndex12++) {
      var pageData12 = pageList12[pageIndex12];
      output += RecommendedPages.renderPage_({page: pageData12});
    }
  }
  output += '</ul></div></section>';
  return soydata.VERY_UNSAFE.ordainSanitizedHtml(output);
};
if (goog.DEBUG) {
  RecommendedPages.render.soyTemplateName = 'RecommendedPages.render';
}


RecommendedPages.renderPage_ = function(opt_data, opt_ignored) {
  opt_data = opt_data || {};
  goog.asserts.assert(opt_data.page == null || opt_data.page != null, "expected param 'page' of type (?).");
  var page = /** @type {(?)} */ (opt_data.page);
  return soydata.VERY_UNSAFE.ordainSanitizedHtml('<li class="list-group-item"><div class="list-group-item-content"><h3><a href="' + soy.$$escapeHtmlAttribute(soy.$$filterNormalizeUri(page.url)) + '">' + soy.$$escapeHtml(page.title) + '</a></h3><p class="text-default">' + soy.$$escapeHtml(page.extractedContent) + '</p></div></li>');
};
if (goog.DEBUG) {
  RecommendedPages.renderPage_.soyTemplateName = 'RecommendedPages.renderPage_';
}
