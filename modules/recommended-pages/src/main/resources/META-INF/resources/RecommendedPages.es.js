import Component from 'metal-component/src/Component';
import Soy from 'metal-soy/src/Soy';
import templates from './RecommendedPages.soy';

class RecommendedPages extends Component {
	constructor(opt_config) {
		super(opt_config);
	}
}

// Register component
Soy.register(RecommendedPages, templates);

export default RecommendedPages;