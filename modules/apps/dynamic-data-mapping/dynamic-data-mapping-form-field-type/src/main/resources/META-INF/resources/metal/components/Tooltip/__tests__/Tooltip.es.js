import Tooltip from '../Tooltip.es';
import {dom as MetalTestUtil} from 'metal-dom';

let component;
const spritemap = 'icons.svg';

describe(
	'Field Tooltip',
	() => {
		beforeEach(
			() => {
				jest.useFakeTimers();
			}
		);

		afterEach(
			() => {
				if (component) {
					component.dispose();
				}
			}
		);

		it(
			'should render the default markup',
			() => {
				component = new Tooltip(
					{
						spritemap,
						icon: 'question-circle-full',
						text: 'This is a tooltip information about this component',
					}
				);

				expect(component).toMatchSnapshot();
			}
		);

		it(
			'should update the tooltip visible state when the mouse is over the tooltip target',
			() => {
				component = new Tooltip(
					{
						spritemap,
						icon: 'question-circle-full',
						text: 'This is a tooltip information about this component',
					}
				);

				jest.runAllTimers();

				const {tooltipTarget} = component.refs;

				MetalTestUtil.triggerEvent(
					tooltipTarget,
					'mouseover'
				);

				expect(component.showContent).toBe(true);
				expect(component).toMatchSnapshot();
			}
		);

		it(
			'should update the tooltip visible state when the mouse leaved the tooltip target',
			() => {
				component = new Tooltip(
					{
						spritemap,
						icon: 'question-circle-full',
						text: 'This is a tooltip information about this component',
					}
				);


				// jest.runAllTimers();

				// const {tooltipTarget} = component.refs;

				// jest.useFakeTimers();

				// MetalTestUtil.triggerEvent(
				// 	tooltipTarget,
				// 	'mouseover'
				// );

				// jest.runAllTimers();

				// jest.useFakeTimers();

				// MetalTestUtil.triggerEvent(
				// 	tooltipTarget,
				// 	'moseleave'
				// );

				// jest.runAllTimers();

				component._handleTooltipHovered();
				component._handleTooltipLeaved();

				expect(component.showContent).toBe(false);
				expect(component).toMatchSnapshot();
			}
		);

		it(
			'should update the tooltip visible state when the mouse is over the tooltip target',
			() => {
				component = new Tooltip(
					{
						spritemap,
						icon: 'question-circle-full',
						text: 'This is a tooltip information about this component',
					}
				);

				jest.runAllTimers();

				component.refs.tooltipSource = {
					element: document.createElement('div'),
				};

				component._handleTooltipHovered();
				component._handleTooltipRendered();

				expect(component.showContent).toBe(true);
				expect(component).toMatchSnapshot();
			}
		);
	}
);
