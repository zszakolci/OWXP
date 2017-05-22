import core from 'metal/src/core';
import Ajax from 'metal-ajax/src/Ajax';
import Component from 'metal-component/src/Component';
import MultiMap from 'metal-multimap/src/MultiMap';
import Soy from 'metal-soy/src/Soy';

import templates from './RecommendedPages.soy';

class RecommendedPages extends Component {
	rendered() {
		$(document).ready(this.setOWLCarousel.bind(this));
	}

	constructor(opt_config) {
		super(opt_config);

		this.name = 'Recommended Pages';

		this.getRecommendedPagesURL = opt_config.getRecommendedPagesURL;
		this.portletNamespace = opt_config.portletNamespace;

		this.start = 0;
		this.end = 10;

		this.getRecommendedPages_();
	}

	setOWLCarousel() {
		$('#' + this.id + ' .list-group').owlCarousel();
	}

	getRecommendedPages_() {
		this.loading = true;

		let opt_params = new MultiMap();

		opt_params.add(this.portletNamespace + 'start', this.start);
		opt_params.add(this.portletNamespace + 'end', this.end);

		Ajax.request(
			this.getRecommendedPagesURL,
			'GET',
			null,
			null,
			opt_params
		)
		.then((data) => {
			if (data.response) {
				this.recommendedPages = JSON.parse(data.response);

				this.name = 'Recommended Pages (' + this.recommendedPages.length + ')';
			}
		});
	}
}

RecommendedPages.STATE = {
	recommendedPages: {
		value: []
	},

	name: {
		value: ''
	}
}

Soy.register(RecommendedPages, templates);

export default RecommendedPages;